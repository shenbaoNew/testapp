package com.digiwin.testapp.design.template;

/**
 * FileName:Game
 * Author: shenbao
 * Date: 2022/5/2 23:41
 * Description:
 */
public abstract class Game {
    public abstract void start();

    public abstract void end();

    public abstract void init();

    /**
     * 模板方法，用来定义执行的框架，至于具体的步骤，可以交由具体的子类来完成
     * 为了防止被恶意更改，申明为final
     */
    public final void play() {
        init();

        start();

        end();
    }
}

class Cricket extends Game {

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void end() {
        System.out.println("end");
    }

    @Override
    public void init() {
        System.out.println("init");
    }
}

class Demo{
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
    }
}