package com.mserafin.template.application.example.commands.update;

import com.mserafin.template.domain.example.Example;
import com.mserafin.template.infrastructure.cqrs.interfaces.commands.Command;


public class UpdateDataCommand implements Command
{
    private final Example data;

    public UpdateDataCommand(final Example example)
    {
        this.data = example;
    }

    public Example getData()
    {
        return data;
    }
}