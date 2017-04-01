package com.varvet.barcodereadersample.model;

/**
 * Created by Alex Thien An Le on 4/1/2017.
 */

public enum Role {

    Worker("Worker", 1),
    Customer("Customer", 2),
    SecurityWorker("Security Worker", 3);

    private String roleName;
    private int roleValue;

    Role(String roleName, int roleValue) {
        this.roleName = roleName;
        this.roleValue = roleValue;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(int roleValue) {
        this.roleValue = roleValue;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", roleValue=" + roleValue +
                '}';
    }
}
