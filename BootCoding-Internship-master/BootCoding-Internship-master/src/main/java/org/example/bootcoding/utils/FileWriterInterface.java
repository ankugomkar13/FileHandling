package org.example.bootcoding.utils;

import org.example.bootcoding.model.Assignment;

import java.util.List;
import java.util.Objects;

public interface FileWriterInterface {
    void write(List<Assignment> list,String filename);
}
