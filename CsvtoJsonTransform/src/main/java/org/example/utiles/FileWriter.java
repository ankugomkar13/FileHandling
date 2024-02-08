package org.example.utiles;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.model.Assignment;

import java.util.List;

public interface FileWriter
{
    public void write(List<Assignment> list);
}
