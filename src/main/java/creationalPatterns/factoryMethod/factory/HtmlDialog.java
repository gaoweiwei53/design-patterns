package creationalPatterns.factoryMethod.factory;

import creationalPatterns.factoryMethod.buttons.Button;
import creationalPatterns.factoryMethod.buttons.HtmlButton;

/**
 * HTML Dialog will produce HTML buttons.
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}