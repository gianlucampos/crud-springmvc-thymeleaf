$("#preco").maskMoney({
    // The symbol to be displayed before the value entered by the user
    prefix: 'R$ ',

    // The suffix to be displayed after the value entered by the user(example: "1234.23 €"). 
    suffix: "",

    // Delay formatting of text field until focus leaves the field
    formatOnBlur: true,

    // Prevent users from inputing zero
    allowZero: false,

    // Prevent users from inputing negative values
    allowNegative: false,

    // Allow empty input values, so that when you delete the number it doesn't reset to 0.00. 
    allowEmpty: false,

    // Select text in the input on double click
    doubleClickSelection: true,

    // Select all text in the input when the element fires the focus event. 
    selectAllOnFocus: false,

    // The thousands separator
    thousands: '.',

    // The decimal separator
    decimal: ',',

    // How many decimal places are allowed
    precision: 2,

    // Set if the symbol will stay in the field after the user exits the field. 
    affixesStay: false,

    // Place caret at the end of the input on focus 
    bringCaretAtEndOnFocus: true
});
