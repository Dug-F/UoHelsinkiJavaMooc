
public class MagicSquareFactory {

    private int size;
    private MagicSquare square;
    
    public MagicSquare createMagicSquare(int size) {
        this.square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        this.size = size;
        
        int column = size / 2;
        int row  = 0;
        
        for (int i = 0; i < size * size; i++) {
            this.square.placeValue(column, row, i + 1);
            
            if (this.nextSquareOccupied(row, column)) {
                row = this.indexForward(row);
                continue;
            }
            
            row = this.indexBack(row);
            column = this.indexForward(column);
        }
        
        return square;
    }
    
    private int indexBack(int index) {
        index--;
        if (index < 0) {
            return this.size - 1;
        }
        return index;
    }
    
    private int indexForward(int index) {
        index++;
        if (index >= this.size) {
            return 0;
        }
        return index;
    }
    
    private boolean nextSquareOccupied(int row, int column) {
        int nextRow = this.indexBack(row);
        int nextColumn = this.indexForward(column);
        
        if (this.square.readValue(nextColumn, nextRow) == 0) {
            return false;
        }
        return true;
    }
    

}
