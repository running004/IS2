package presentacion.Sesion;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import negocio.Sesion.TSesion;
import presentacion.Controller;
import presentacion.GUIMaker;
import presentacion.eventos;
import resources.fechasConverter;


public class GUIMostrarTodasSesionesAlumno extends JFrame {
	private static final long serialVersionUID = 1L;
	private boolean isInit=false, isInit2=false;
	private JTable tabla;
	private JPanel panelcentro = new JPanel(new FlowLayout());
	private String[] colNames = {"id", "fecha","horaIni","horaFin","tipo","activo","idAlumno", "idProfesor"};
	
	
	public String getValueAt(List<TSesion> lista, int arg0, int arg1) {
		String s = null;
		switch (arg1) {
		case 0:
			s = Integer.toString(lista.get(arg0).getId());
			break;
		case 1:
			s = fechasConverter.fechaToString(lista.get(arg0).getFecha());
			break;
		case 2:
			s = fechasConverter.horaToString(lista.get(arg0).getHoraini());
			break;
		case 3:
			s = fechasConverter.horaToString(lista.get(arg0).getHorafin());
			break;
		case 4:
			s = lista.get(arg0).getTipo();
			break;
		case 5:
			s = Boolean.toString(lista.get(arg0).isActivo());
			break;	
		case 6:
			s = Integer.toString(lista.get(arg0).getIdAlumno());
			break;
		case 7:
			s = Integer.toString(lista.get(arg0).getIdProfesor());
			break;
		}
		return s;
	}
	public void initGui() {
		if(isInit) {
			setVisible(true);
			return;
		}
		isInit=true;
		tabla= new JTable();
		this.setLayout(new BorderLayout());
		GUIMaker.getInstance().configurateSubWindow(this,650,200,"Mostrar sesion de un alumno ");
		JPanel panelEtiq = new JPanel(new FlowLayout());
		JLabel lbl= new JLabel ("Inserta ID alumno, por favor: ");
		JTextField idCampo = new JTextField();
		idCampo.setColumns(5);
		panelEtiq.add(lbl);
		panelEtiq.add(idCampo);
		add(panelEtiq, BorderLayout.NORTH);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dato = Integer.parseInt(idCampo.getText());
				Controller.getInstance().accion(eventos.MOSTRAR_TODOS_SESION_ALUMNO,dato);
				}
			});
		
		panelcentro.add(btnBuscar);
		add(panelcentro,BorderLayout.WEST);
		this.setVisible(true);
		
	}
	
	
	
	public void mostrarSesiones(List<TSesion> lista) {
		if(isInit2) {
			setVisible(true);
			actualizarTabla(lista);
			return;
		}
		isInit2=true;
		GUIMaker.getInstance().configurateSubWindow(this, 1200, 800, "Mostrar sesion de un alumno");
		tabla= new JTable();
		actualizarTabla(lista);
		tabla.getTableHeader().setReorderingAllowed(false);
		JScrollPane p= new JScrollPane(tabla);
		this.pack();
		this.add(p);
		this.setSize(720,450);
		this.setVisible(true);
		
	}
	private void actualizarTabla(List<TSesion> lista) {
		String[][]datos= new String[lista.size()][colNames.length];
		for(int i=0;i<lista.size();++i) 
			for(int j=0;j<colNames.length;++j) 
				datos[i][j]= getValueAt(lista,i,j);
				
		DefaultTableModel tmodel = new DefaultTableModel(datos,colNames) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tabla.setModel(tmodel);
	}
}
