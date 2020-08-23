import com.intellij.ide.util.PropertiesComponent;
import utils.LogUtil;
import utils.StockRefreshHandler;
import utils.TencentStockHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StockWindow {
    private JPanel panel1;
    private JTable table1;
    private JLabel label;
    private JButton detailBtn;

    StockRefreshHandler handler;

    public JPanel getPanel1() {
        return panel1;
    }

    public StockWindow() {
        handler = new TencentStockHandler(table1,label);
    }

    public void onInit(){
        boolean colorful = PropertiesComponent.getInstance().getBoolean("key_colorful");
        boolean autoUpdateS = PropertiesComponent.getInstance().getBoolean("auto_update_s");
        int timerS = PropertiesComponent.getInstance().getInt("timer_s", 10);
        handler.setColorful(colorful);
        handler.setAutoUpdate(autoUpdateS);
        handler.setTimer(timerS);
        handler.handle(loadStocks());
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        detailBtn.addActionListener(e -> {
            if (table1.getSelectedRow() < 0) {
                return;
            }
            String nameCode = table1.getModel().getValueAt(table1.getSelectedRow(), 0).toString();
            if (nameCode == null || nameCode == "" || nameCode.split("-").length < 2) {
                return;
            }
            String code = nameCode.split("-")[1];
            StockDetailDialog dialog = new StockDetailDialog();
            dialog.init(code);
            dialog.pack();
            dialog.setVisible(true);


//            System.exit(0);
        });

    }

    private List<String> loadStocks(){
        ArrayList<String> temp = new ArrayList<>();
        String value = PropertiesComponent.getInstance().getValue("key_stocks");
//        String value = "sh600519,sz000001";
        if (value == null){
            return temp;
        }
        String[] codes = value.split("[,，]");
        for (String code : codes) {
            if (!code.isEmpty()){
                temp.add(code);
            }
        }
        return temp;
    }

}
