package com.christoff.aotearoa.extern.gateway.view;

import com.christoff.aotearoa.intern.gateway.view.IPresenter;

public class PresenterCLI implements IPresenter
{
    @Override
    public void tagDefinedNotUsed(String tagName) {
        System.out.println("WARNING: Tag " + tagName + " defined, but never used");
    }
    
    @Override
    public void persistingValuesBegin() {
        System.out.print("Resolving templates...");
    }
    
    @Override
    public void persistingValuesEnd() {
        System.out.println("done.");
    }
}
