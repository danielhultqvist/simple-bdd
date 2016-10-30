package io.hultqvist.simplebdd.report;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScenarioReport {

    @XmlElement(name = "status")
    public ScenarioStatus scenarioStatus;

    @XmlElement(name = "className")
    public String className = "asd";

    @XmlElement(name = "title")
    public String title = "el titlo";

    @XmlElement(name = "description")
    public String description = "maj description";

    @XmlElement(name = "failureMessage")
    public String failureMessage = "Message";

    @XmlElement(name = "failureStack")
    public String failureStack;

    /*
  "className": "com.tngtech.jgiven.junit.DescriptionTest",
          "name": "Description",
          "description": "Some description for the test class",
*/

    public ScenarioReport() {
    }

    public ScenarioReport(final ScenarioStatus scenarioStatus,
                          final String className,
                          final String title,
                          final String description,
                          final String failureMessage,
                          final String failureStack) {
        this.scenarioStatus = scenarioStatus;
        this.className = className;
        this.title = title;
        this.description = description;
        this.failureMessage = failureMessage;
        this.failureStack = failureStack;
    }
}
