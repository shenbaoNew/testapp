package com.digiwin.testapp.design.chain;

interface BudgetHandler {
    void setNextHandler(BudgetHandler next);

    void handle(int amount);
}

class Leader implements BudgetHandler {
    private BudgetHandler next;

    @Override
    public void setNextHandler(BudgetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(int amount) {
        if (amount <= 1000) {
            System.out.println("leader 已同意....");
            return;
        }
        System.out.println("超出leader范围");
        if (next != null) {
            next.handle(amount);
        }
    }
}

class Manager implements BudgetHandler {
    private BudgetHandler next;

    @Override
    public void setNextHandler(BudgetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(int amount) {
        if (amount <= 5000) {
            System.out.println("manager 已同意....");
            return;
        }
        System.out.println("超出manager范围");
        if (null != next) {
            next.handle(amount);
        }
    }
}

class CFO implements BudgetHandler {
    private BudgetHandler next;

    @Override
    public void setNextHandler(BudgetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(int amount) {
        System.out.println("CFO 已同意....");
    }
}