//Check duplicated values to add in a stack
function inArray(value, stack) {
    for (var i in stack) {
        if (stack[i] === value && stack[i] !== typeof 'undefined')
            return true;
    }
    return false;
}