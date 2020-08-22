import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SettingsWindow  implements Configurable {
    private JPanel panel1;
    private JLabel label;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox checkbox;
    private JCheckBox autoUpdateF;
    private JCheckBox autoUpdateS;
    private JTextField timerF;
    private JTextField timerS;

    private String orgin;

    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "Leeks";
    }

    @Override
    public @Nullable JComponent createComponent() {
        String value = PropertiesComponent.getInstance().getValue("key_funds");
        String value_stock = PropertiesComponent.getInstance().getValue("key_stocks");
        boolean value_color = PropertiesComponent.getInstance().getBoolean("key_colorful");
        boolean auto_update_f = PropertiesComponent.getInstance().getBoolean("auto_update_f");
        boolean auto_update_s = PropertiesComponent.getInstance().getBoolean("auto_update_s");
        int timer_f = PropertiesComponent.getInstance().getInt("timer_f", 60);
        int timer_s = PropertiesComponent.getInstance().getInt("timer_s", 10);
        textField1.setText(value);
        textField2.setText(value_stock);
        checkbox.setSelected(!value_color);
        autoUpdateF.setSelected(auto_update_f);
        autoUpdateS.setSelected(auto_update_s);
        timerF.setText(String.valueOf(timer_f));
        timerS.setText(String.valueOf(timer_s));
        return panel1;
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        PropertiesComponent.getInstance().setValue("key_funds",textField1.getText());
        PropertiesComponent.getInstance().setValue("key_stocks",textField2.getText());
        PropertiesComponent.getInstance().setValue("key_colorful",!checkbox.isSelected());
        PropertiesComponent.getInstance().setValue("auto_update_f", autoUpdateF.isSelected());
        PropertiesComponent.getInstance().setValue("auto_update_s", autoUpdateS.isSelected());
        PropertiesComponent.getInstance().setValue("timer_f", timerF.getText());
        PropertiesComponent.getInstance().setValue("timer_s", timerS.getText());

    }
}
