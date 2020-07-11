package lk.kln.mit;

public abstract class Converter extends Thread{
    protected abstract void encode();
    public abstract void run();
}
