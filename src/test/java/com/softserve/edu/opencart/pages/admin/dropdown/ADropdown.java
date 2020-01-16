package com.softserve.edu.opencart.pages.admin.dropdown;


public abstract class ADropdown {

    protected ADropdown dropdown;

    protected ADropdown(ADropdown dropdown) {
        this.dropdown = dropdown;
    }

    public void transferNextDropdownList(DropdownList dropdownList) {
        if (dropdown != null) {
            dropdown.transferNextDropdownList(dropdownList);
        }
    }

}
