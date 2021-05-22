package com.nbsaas.adminstore.analysis.simple;

import lombok.Data;

import java.io.Serializable;

@Data
public class LongName implements Serializable {

    private String label;

    private Long num;
}
