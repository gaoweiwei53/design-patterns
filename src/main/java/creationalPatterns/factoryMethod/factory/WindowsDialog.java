package creationalPatterns.factoryMethod.factory;


import creationalPatterns.factoryMethod.buttons.Button;
import creationalPatterns.factoryMethod.buttons.WindowsButton;

/**
 * Windows Dialog will produce Windows buttons.
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
