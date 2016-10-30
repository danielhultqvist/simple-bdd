package io.hultqvist.simplebdd.report;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "status")
@XmlEnum
public enum ScenarioStatus {
    PASSED, FAILED, IGNORED
}
