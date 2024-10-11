package project;

public class Main
{
    public static void main(String[] args) {
        IDandPassword idandpass = new IDandPassword();
        Login loginpage = new Login(idandpass.getinfor());
    }
}
