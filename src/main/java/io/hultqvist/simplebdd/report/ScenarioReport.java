package io.hultqvist.simplebdd.report;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ScenarioReport {

  @XmlElement(name = "status")
  public ScenarioStatus scenarioStatus;

  @XmlElement(name = "className")
  public String className;

  @XmlElement(name = "title")
  public String title;

  @XmlElement(name = "description")
  public String description;

  @XmlElement(name = "failureMessage")
  public String failureMessage;

  @XmlElement(name = "failureStack")
  public String failureStack;

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