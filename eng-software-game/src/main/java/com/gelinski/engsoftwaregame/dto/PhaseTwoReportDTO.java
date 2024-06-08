package com.gelinski.engsoftwaregame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PhaseTwoReportDTO {
    private List<PartsPhaseTwoDTO> parts;

}
