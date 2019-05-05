//Change background cell color onclick
function paintCell(cell){

    var currentCellColor = window.getComputedStyle(cell);

    currentCellColor = currentCellColor.getPropertyValue('background-color');

    if('rgba(0, 0, 0, 0)' == currentCellColor || 'transparent' == currentCellColor){
        cell.style.background = '#0076CE'; //blue
        cell.style.color = '#ffffff';

    }
    else if('rgb(0, 118, 206)' == currentCellColor){
        cell.style.background = '#50ce78'; //green
        cell.style.color = '#000000';
        // Paints next cell
        // if(value1 == value2){
        //     cell.nextElementSibling.style.background = '#50ce78'; //green
        //     cell.nextElementSibling.style.color = '#000000';
        // }
    }
    else if ('rgb(80, 206, 120)' == currentCellColor){
        cell.style.background = '#ff0000'; //red
        cell.style.color = '#ffffff';
    }
    else if('rgb(255, 0, 0)' == currentCellColor){
        cell.removeAttribute("style");
    }
}

//Using
onclick="paintCell(this)"