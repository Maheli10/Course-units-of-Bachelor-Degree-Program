function validate_confirmpassword(field1, field2) {
    if (field1 !== field2) {
        return 'Passwords do not match.';
    } else {
        return '';
    }
}