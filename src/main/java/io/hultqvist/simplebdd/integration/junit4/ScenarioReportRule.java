package io.hultqvist.simplebdd.integration.junit4;

import io.hultqvist.simplebdd.report.ScenarioReport;
import io.hultqvist.simplebdd.report.ScenarioStatus;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

// FIXME [dh] Should write to file instead of stdout
// FIXME [dh] Support for skipped
// FIXME [dh] The actual logic should most likely not be in the JUnit4 integration
public class ScenarioReportRule extends TestWatcher {

  @Override
  protected void succeeded(Description description) {
    super.succeeded(description);
    write(new ScenarioReport(ScenarioStatus.PASSED,
                             description.getClassName(),
                             description.getClass().toString(),
                             description.getClassName(),
                             null,
                             null));
  }

  @Override
  protected void failed(Throwable e, Description description) {
    super.failed(e, description);

    StringWriter errors = new StringWriter();
    e.printStackTrace(new PrintWriter(errors));
    final String stackTrace = errors.toString();

    write(new ScenarioReport(ScenarioStatus.FAILED,
                             description.getClassName(),
                             description.getClass().toString(),
                             description.getClassName(),
                             e.getMessage(),
                             stackTrace));
  }

  private void write(final ScenarioReport report) {
    try {
      final JAXBContext jaxbContext = JAXBContext.newInstance(ScenarioReport.class);

      final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(report, System.out);
      System.out.println("\n\n");
    } catch (JAXBException e) {
      throw new RuntimeException(e);
    }
  }
}