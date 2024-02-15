package org.example.bootcoding.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Assignment {
    int QID;
    String title;
    String difficultyLevel;
    Double acceptanceRate;
    boolean paidOnly;


}
