function validVote(aString) {
    len = aString.length;
    if (len == 1) {
        return ((aString.charAt(0) >= "0") && (aString.charAt(0) <= "9"));
    } else if (len == 2) {
        return (aString == "10");
    } else {
        return false;
    }
}

function submitForm(aForm) {    if (validVote(aForm.vote.value)) {
	return true;
    } else {
        alert("Invalid vote!  Must be 0-10")
	aForm.vote.focus()
	aForm.vote.select()
	return false;
    }
}