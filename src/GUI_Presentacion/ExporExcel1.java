package GUI_Presentacion;

//import presentacionArteArcilla.*;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import static jxl.write.WritableImage.MOVE_AND_SIZE_WITH_CELLS;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExporExcel1 {

    private File archi;
    private List<JTable> tabla;
    private String nomhoja;
    private int hoja;
    private WritableCellFormat fomato_fila;
    private WritableCellFormat fomato_columna;
    private WritableSheet s;
    private WritableWorkbook w;
    private JTable table;
    public String TITULO1, TITULO2, TITULO3, FORMATO, VERSION;

    public ExporExcel1(List<JTable> tab, String nombre, int num, File ar) throws Exception {
        this.archi = ar;
        this.tabla = tab;
        this.nomhoja = nombre;
        this.hoja = num;
        if (tab.size() < 0) {
            throw new Exception("ERROR");
        }
    }

    public boolean export() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(archi));
            w = Workbook.createWorkbook(out);
            w.createSheet(nomhoja, hoja);
            for (int index = 0; index < tabla.size(); index++) {
                table = tabla.get(index);
                s = w.getSheet(0);
                ImprimirImagen(s);
                for (int i = 1; i < table.getColumnCount() - 1; i++) {
                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object objeto = table.getValueAt(j, i);
                        createColumna(s, table.getColumnName(i), i - 1);//crea la columna
                        createFilas(s, i, j + 1, String.valueOf(objeto));//crea las filas                        
                    }
                }
            }
            w.write();
            w.close();
            out.close();
            return true;

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (WriteException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return false;
    }

    @SuppressWarnings({"deprecation"})
    private void createColumna(WritableSheet sheet, String columna, int number_columna) throws WriteException {
        try {
            WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TAHOMA, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
            fomato_columna = new WritableCellFormat(times10ptBoldUnderline);
            fomato_columna.setBorder(Border.ALL, BorderLineStyle.MEDIUM, Colour.BLACK);//se le da borde y color  
            fomato_columna.setVerticalAlignment(VerticalAlignment.CENTRE); //centro verticalmente 
            fomato_columna.setAlignment(Alignment.CENTRE);//centro horisontalmente       
            addColumna(sheet, number_columna, 4, columna, fomato_columna);//numero de columna , 0 es la fila
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * *************************************
     */
    @SuppressWarnings("deprecation")
    private void createFilas(WritableSheet sheet, int number_columna, int filas, String name_filas) throws WriteException {
        try {
            WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.ARIAL, 8, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);// crea una negrita con subrayado
            fomato_fila = new WritableCellFormat(times10ptBoldUnderline);
            fomato_fila.setWrap(true);// Permite que se ajusta automoticamente a las celulas al contenido 
            fomato_fila.setBorder(Border.ALL, BorderLineStyle.DASHED, Colour.BLACK);//se le da borde y color              
            fomato_fila.setVerticalAlignment(VerticalAlignment.CENTRE); //centro verticalmente 
            fomato_fila.setAlignment(Alignment.LEFT);//centro horisontalmente

            addFilas(sheet, number_columna - 1, filas + 4, name_filas, fomato_fila);//para no imprimir el id
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * ********************************
     */
    @SuppressWarnings({"deprecation"})
    private void addColumna(WritableSheet sheet, int column, int row, String s, WritableCellFormat format) throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, "    " + s + "    ", format);
        sheet.addCell(label);
        CellView cevell = new CellView();
        cevell.setAutosize(true);    //activa el ajuste automatico de las columnas   
        sheet.setColumnView(column, cevell);
        ImprimirEncabesado(sheet, format, TITULO1, TITULO2, TITULO3, "", FORMATO, VERSION);

    }

    private void addFilas(WritableSheet sheet, int column, int row, String s, WritableCellFormat format) throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, format);
        sheet.addCell(label);
    }

    public void ImprimirEncabesado(WritableSheet sheet, WritableCellFormat format, String dato0, String dato1, String dato2, String dato3, String dato4, String dato5) throws WriteException {
        WritableCell titleCell0 = new Label(0, 0, "", format);
        sheet.addCell(titleCell0);
        sheet.mergeCells(0, 0, 0, 3);//epacio para imagen
        WritableCell titleCell = new Label(1/*columna x*/, 0/*celda y*/, /*texto*/ dato0, format/*formato*/);
        sheet.addCell(titleCell);
        sheet.mergeCells(1/*celda inicio*/, 0/*x*/, table.getColumnCount() - 4/*celda termina*/, 0/*y*/);
        WritableCell titleCell1 = new Label(1, 1, dato1, format);
        sheet.addCell(titleCell1);
        sheet.mergeCells(1, 1, table.getColumnCount() - 4, 1);
        WritableCell titleCell2 = new Label(1, 2, dato2, format);
        sheet.addCell(titleCell2);
        sheet.mergeCells(1, 2, table.getColumnCount() - 4, 2);
        WritableCell titleCell3 = new Label(1, 3, dato3, format);
        sheet.addCell(titleCell3);
        sheet.mergeCells(1, 3, table.getColumnCount() - 3, 3);
        WritableCell titleCell4 = new Label(table.getColumnCount() - 3, 0, dato4, format);
        sheet.addCell(titleCell4);
        WritableCell titleCell5 = new Label(table.getColumnCount() - 3, 1, dato5, format);
        sheet.addCell(titleCell5);
        sheet.mergeCells(table.getColumnCount() - 3, 1, table.getColumnCount() - 3, 2);
    }

    public void ImprimirImagen(WritableSheet sheet) throws WriteException, IOException {
        File imageFile = new File("C:\\Sistema\\ico\\Pescadero128x128.png");
//          File imageFile = new File("C:\\Sistema\\ico\\Pescadero128x128.jpg");
        WritableImage imgobj = new WritableImage(0.10/*celda x*/, 0.50/*celda y*/, 0.80/*ancho*/, 3.0/*alto*/, imageFile);
        imgobj.setImageAnchor(MOVE_AND_SIZE_WITH_CELLS);//propiedades de anclaje imagen que mover y redimensionar una imagen junto con las células
//        imgobj.setImageAnchor(MOVE_WITH_CELLS);//propiedades de anclaje imagen que mover una imagen cuando se insertan o eliminan las células
//        imgobj.setImageAnchor(NO_MOVE_OR_SIZE_WITH_CELLS);//propiedades de anclaje imagen que dejará una imagen afectada cuando se insertan 
        sheet.addImage(imgobj);

    }
}
