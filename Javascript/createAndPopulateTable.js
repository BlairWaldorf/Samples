//Creating table and lables and setting values to cells
function createTable(table, rows, cells, myObject) {

    var row;
    var value;

    if (!table) table = document.createElement('table');

    for (var r = 0; r < rows; r++) {

        row = document.createElement('tr');
        value = Object.keys(myObject);

        for (var c = 0; c < cells; c++) {

            row.appendChild(document.createElement('td'));
            //first column lables
            if (r > 0 && c === 0) {
                row.cells[c].appendChild(document.createTextNode('label1'));
            }
            //0.0 cell lable
            else if (r === 0 && c === 0) {
                row.cells[c].appendChild(document.createTextNode('label2'));
            }
            // Header Table lables
            else if (c > 0 && r === 0) {
                row.cells[c].appendChild(document.createTextNode(value[c - 1]));
            }
            // cells content
            }
        }
        table.appendChild(row);
    }
    return table;
}