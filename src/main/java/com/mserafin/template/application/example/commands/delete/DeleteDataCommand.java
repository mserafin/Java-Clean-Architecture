package com.mserafin.template.application.example.commands.delete;

import com.mserafin.template.infrastructure.cqrs.interfaces.commands.Command;


public class DeleteDataCommand implements Command
{
    private final Long id;

    public DeleteDataCommand(final Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
}
