package com.softserve.edu.opencart.pages.admin.dropdown;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class FirstLevelHandler extends ADropdown {
    private final String LOCALISATION = "Localisation";

    private DropdownList dropdownList;

    protected FirstLevelHandler(ADropdown dropdown) {
        super(dropdown);
    }

    @Override
    public void transferNextDropdownList(DropdownList dropdownList) {
        if(dropdownList.getElementsFirstLevel().contains(LOCALISATION)){
            dropdownList.getElementsFirstLevel().get(2).click();
            dropdown.transferNextDropdownList(null);
        }
    }
}
