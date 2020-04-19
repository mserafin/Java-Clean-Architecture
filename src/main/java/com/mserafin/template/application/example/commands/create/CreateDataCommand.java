package com.mserafin.template.application.example.commands.create;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.Command;


public class CreateDataCommand implements Command
{
    private final Example data;

    public CreateDataCommand(final Example example)
    {
        this.data = example;
    }

    public Example getData()
    {
        return data;
    }
}
