package OOP2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DiceSimulator extends JFrame {

    // 顯示骰子點數
    private JLabel diceLabel;

    // 顯示統計資料
    private JLabel infoLabel;

    // 記錄擲骰子的次數
    private int count = 0;

    // 記錄所有骰子的總和
    private int sum = 0;

    // 產生亂數
    private Random random = new Random();

    public DiceSimulator() {

        // 設定視窗標題
        setTitle("骰子模擬器");

        // 設定視窗大小
        setSize(400, 320);

        // 關閉視窗時結束程式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 視窗開啟時置中
        setLocationRelativeTo(null);

        // 設定版面配置
        setLayout(new BorderLayout());

        // =========================
        // 上方：統計資訊
        // =========================

        infoLabel = new JLabel("已擲 0 次，總和 0，平均 0.00");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(infoLabel, BorderLayout.NORTH);


        // =========================
        // 中間：骰子點數
        // =========================

        diceLabel = new JLabel("0");
        diceLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 設定字體大小 60pt
        diceLabel.setFont(new Font("Arial", Font.PLAIN, 60));

        add(diceLabel, BorderLayout.CENTER);


        // =========================
        // 下方：擲骰子按鈕
        // =========================

        JButton rollButton = new JButton("擲骰子");

        add(rollButton, BorderLayout.SOUTH);


        // =========================
        // 按鈕事件
        // =========================

        rollButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 產生 1~6 的亂數
                int dice = random.nextInt(6) + 1;

                // 更新骰子點數
                diceLabel.setText(String.valueOf(dice));

                // 擲骰次數 +1
                count++;

                // 將這次的點數加入總和
                sum += dice;

                // 計算平均
                double average = (double) sum / count;

                // 更新統計資訊
                infoLabel.setText(
                    String.format(
                        "已擲 %d 次，總和 %d，平均 %.2f",
                        count, sum, average
                    )
                );

                // 根據點數設定文字顏色
                if (dice == 6) {
                    diceLabel.setForeground(Color.GREEN);
                }
                else if (dice == 1) {
                    diceLabel.setForeground(Color.RED);
                }
                else {
                    diceLabel.setForeground(Color.BLACK);
                }
            }
        });
    }


    // =========================
    // main 方法
    // =========================

    public static void main(String[] args) {

        // 建立骰子模擬器視窗
        DiceSimulator frame = new DiceSimulator();

        // 顯示視窗
        frame.setVisible(true);
    }
}