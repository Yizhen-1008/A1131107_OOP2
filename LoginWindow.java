import javax.swing.*;

public class LoginWindow extends JFrame {

    public LoginWindow() {

        // 視窗標題
        setTitle("登入");

        // 視窗大小
        setSize(300, 200);

        // 關閉視窗時結束程式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 不使用版面配置
        setLayout(null);

        // 帳號標籤
        JLabel l1 = new JLabel("帳號：");
        l1.setBounds(40, 30, 60, 30);

        // 帳號輸入框
        JTextField t1 = new JTextField();
        t1.setBounds(100, 30, 150, 30);

        // 密碼標籤
        JLabel l2 = new JLabel("密碼：");
        l2.setBounds(40, 70, 60, 30);

        // 密碼輸入框
        JPasswordField t2 = new JPasswordField();
        t2.setBounds(100, 70, 150, 30);

        // 登入按鈕
        JButton btn = new JButton("登入");
        btn.setBounds(100, 115, 80, 30);

        // 把元件放進視窗
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        // 按下登入按鈕
        btn.addActionListener(e -> {

            String account = t1.getText();
            String password = new String(t2.getPassword());

            // 判斷帳號密碼
            if (account.equals("admin") && password.equals("1234")) {

                JOptionPane.showMessageDialog(
                    this,
                    "登入成功！"
                );

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "帳號或密碼錯誤！"
                );
            }
        });

        // 顯示視窗
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}