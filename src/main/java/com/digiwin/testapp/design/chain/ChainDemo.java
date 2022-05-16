package com.digiwin.testapp.design.chain;

class ChainDemo {
    public static void main(String[] args) {
        BudgetHandler leader = new Leader();
        BudgetHandler manager = new Manager();
        BudgetHandler cfo = new CFO();
        leader.setNextHandler(manager);
        manager.setNextHandler(cfo);

        leader.handle(500);
        leader.handle(1200);
        leader.handle(5500);
    }
}
