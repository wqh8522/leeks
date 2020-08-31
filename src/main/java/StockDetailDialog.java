

import com.intellij.ui.JBColor;
import utils.HttpClientPool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class StockDetailDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    private JLabel stockName;
    private JLabel jinkai;
    private JLabel chenjiaoliang;
    private JLabel zhenfu;
    private JLabel zuigao;
    private JLabel chengjiaoe;
    private JLabel huanshou;
    private JLabel zuidi;
    private JLabel shijinglv;
    private JLabel zuoshou;
    private JLabel shiyinglv;
    private JLabel neipan;
    private JLabel waipan;
    private JLabel updateTime;
    private JLabel dangqianjia;
    private JLabel zhangdie;
    private JLabel zr;
    private JLabel zc;
    private JLabel zjr;
    private JLabel sr;
    private JLabel sc;
    private JLabel sjr;

    public StockDetailDialog() {
        setLocationRelativeTo(null);
        setBounds(500, 200, 800, 1000);
        setSize(new Dimension(5000, 5000));
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }


    public void init(String code) {
        if (code == null || code == "") {
            return;
        }
        initHqData(code);
        initZjData(code);
    }

    private void initZjData(String code){
        try {
            String result = HttpClientPool.getHttpClient().get("Http://qt.gtimg.cn/q=ff_" + code);
            if (result == null || result == ""){
                return;
            }
            String dataStr = result.substring(result.indexOf("=") + 2, result.length() - 2);
            String[] values = dataStr.split("~");
            zr.setText(zr.getText() + values[1]);
            zc.setText(zc.getText() + values[2]);
            zjr.setText(zjr.getText() + values[3]);

            sr.setText(sr.getText() + values[5]);
            sc.setText(sc.getText() + values[6]);
            sjr.setText(sjr.getText() + values[7]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initHqData(String code) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String result = HttpClientPool.getHttpClient().get("http://qt.gtimg.cn/q=" + code);
            if (result == null || result == ""){
                return;
            }
            String dataStr = result.substring(result.indexOf("=") + 2, result.length() - 2);
            String[] values = dataStr.split("~");
            boolean isD = Double.valueOf(values[31]) > 0 ? false : true;
            stockName.setText(values[1] + "-" + values[2]);
            dangqianjia.setText(values[3]);
            zhangdie.setText(values[31] + "    " + values[32] + "%");
            if (isD) {
                dangqianjia.setForeground(JBColor.GREEN);
                zhangdie.setForeground(JBColor.GREEN);
            } else {
                dangqianjia.setForeground(JBColor.RED);
                zhangdie.setForeground(JBColor.RED);
            }
            updateTime.setText(dateFormat.format(new SimpleDateFormat("yyyyMMddHHmmss").parse(values[30])));

            jinkai.setText(jinkai.getText() + values[5]);
            zuigao.setText(zuigao.getText() + values[41]);
            zuidi.setText(zuidi.getText() + values[42]);
            zuoshou.setText(zuoshou.getText() + values[4]);
            if (values[36] != null) {
                String m1 = Double.valueOf(values[36]) < 10000 ? values[36] + "手" : new BigDecimal(Double.valueOf(values[36])/10000)
                        .setScale(0, BigDecimal.ROUND_HALF_UP) + "万手";
                chenjiaoliang.setText(chenjiaoliang.getText() + m1);
            }

            chengjiaoe.setText(chengjiaoe.getText() + values[37]);
//            neipan.setText(neipan.getText() + "<html><font color='green'>" + values[8] +"</font>");
            neipan.setText(neipan.getText() +  values[8]);
//            waipan.setText(waipan.getText() + "<html><font color='red'>" + values[7] +"</font>");
            waipan.setText(waipan.getText() + values[7]);


            zhenfu.setText(zhenfu.getText() + values[43] + "%");
            huanshou.setText(huanshou.getText() + values[38] + "%");
            shijinglv.setText(shijinglv.getText() + values[46]);
            shiyinglv.setText(shiyinglv.getText() + values[39]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
