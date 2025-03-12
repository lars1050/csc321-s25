class Location:
    '''
    Stores the row and column within the world grid (not the graphics window).
    '''
    def __init__(self,**kwargs):
        if "row" in kwargs:
            self.row = kwargs["row"]
        else:
            self.row = 0
        if "col" in kwargs:
            self.col = kwargs["col"]
        else:
            self.col = 0
            
    def __str__(self):
        return f'[r:{self.row},c:{self.col}]'
