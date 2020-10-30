public class Account {
    Double balance;
    public void getBalance(){
        System.out.println("账户余额" + this.balance);
    }

    public void deposit(int num){
        this.balance += num;
    }

    public void withdraw(int num) throws OverdraftException {
        if (num > this.balance) {
            double d = num - this.balance;
            throw new OverdraftException("取款透支", d);
        }

        this.balance -= num;
        System.out.println("账户余额" + this.balance);
    }

    public Account() {}
    public Account(double balance) {
        this.balance = balance;
    }

    class OverdraftException extends Exception{
        double deficit;
        public double getDeficit(){
            return deficit;
        }
        public OverdraftException() {}
        public OverdraftException(String message, double deficit){
            super(message);
            this.deficit = deficit;
        }
    }

    public static void main(String[] args) {
        Account a = new Account((double) 500);
        try {
            a.withdraw(1600);
        } catch (OverdraftException e) {
            e.printStackTrace();
            System.out.println("账户透支" + e.getDeficit());
        }

        a.getBalance();


        CheckingAccount ca = new CheckingAccount(100, 500);
        try {
            ca.withdraw(200);
//            System.out.println();
        } catch (OverdraftException e) {
            e.printStackTrace();
//            System.out.println();
        }
        System.out.println(ca.balance );
        System.out.println(ca.overdraftProtection);

        try {
            ca.withdraw( 500);
        } catch ( OverdraftException e){
            e.printStackTrace();
        }

    }


    static class CheckingAccount extends Account {
        double overdraftProtection;
        public CheckingAccount(double balance){
//            this.balance = balance;
        }
        public CheckingAccount(double balance, double overdraftProtection) {
            super(balance);
            this.overdraftProtection = overdraftProtection;
        }

        @Override
        public void withdraw(int num) throws OverdraftException{
            if (this.balance + this.overdraftProtection < num) {
                double d = num - this.balance - this.overdraftProtection;
                throw new OverdraftException("除了" + this.overdraftProtection +"额度外，还是透支了", d);
//                System.out.println("balance " + this.balance + "额度 " + this.overdraftProtection);
            }
            if (num > this.balance) {
                this.overdraftProtection = this.overdraftProtection + this.balance - num;
                this.balance = Double.valueOf(0);
//                System.out.println("额度剩余" + this.overdraftProtection);
            }
        }
    }


}
