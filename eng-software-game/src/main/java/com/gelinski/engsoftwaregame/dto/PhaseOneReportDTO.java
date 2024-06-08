package com.gelinski.engsoftwaregame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PhaseOneReportDTO {
    private List<ElementsPhaseOneDTO> elements;

}
