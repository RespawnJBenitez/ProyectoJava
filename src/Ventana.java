import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;


public class Ventana extends JFrame{

	JPanel mousePanel;
	JPanel panelviewPerfil, panelBloquear;
	String panelActivo= "";
	JPanel loginUsuarios;
	JPanel crearUsuario;
	JPanel pantallaCarga;
	JPanel panelRegistro;
	ImageIcon newcuentaIcon;
	
	public Ventana() {
		// TODO Auto-generated constructor stub
		
		//Configuracion principal de la ventana
		this.setTitle("QuackBank");
		this.setSize(400,630);
		this.setVisible(true);
		this.setBackground(new Color(70, 125, 244));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		setIconImage(new ImageIcon(getClass().getResource("pngegg.png")).getImage());
		//setLocationRelativeTo(null); 
		//Al presionar el boton dela ventana cerrar, mostrara seleccion si desea cerrar o no
		this.cerrarVentana();
		
		//Crea el menu de la barra arriba
		JMenuBar menu = new JMenuBar();
		menu.setBackground(new Color(254, 72, 40));
		//Crea de lista opciones de la primera linea en cuenta
		JMenu listaDeOpciones = new JMenu("Cuenta");
		listaDeOpciones.setFont(new Font("Yu Gothic UI Semibold",0,16));
		listaDeOpciones.setForeground(Color.WHITE);
		ImageIcon cuentaIcon = new ImageIcon("src/accountIcon.png");
		listaDeOpciones.setIcon(cuentaIcon);
		menu.add(listaDeOpciones);
		
		JMenuItem opcionUno = new JMenuItem("Mi cuenta");
		opcionUno.setFont(new Font("Yu Gothic UI Semibold",0,13));
		opcionUno.setForeground(Color.WHITE);
		opcionUno.setBackground(new Color(196, 87, 17 ));
		ImageIcon perfilIcon = new ImageIcon("src/perfilIcon.png");
		opcionUno.setIcon(perfilIcon);
		listaDeOpciones.add(opcionUno);
		
		
		JMenuItem opcionDos = new JMenuItem("Bloquear");
		opcionDos.setFont(new Font("Yu Gothic UI Semibold",0,13));
		opcionDos.setForeground(Color.WHITE);
		opcionDos.setBackground(new Color(161, 118, 249));
		ImageIcon blockCuenta = new ImageIcon("src/bloquearIcon.png");
		opcionDos.setIcon(blockCuenta);
		listaDeOpciones.add(opcionDos);
		
		JMenuItem opcionTres = new JMenuItem("Cerrar sesión");
		opcionTres.setFont(new Font("Yu Gothic UI Semibold",0,13));
		opcionTres.setForeground(Color.WHITE);
		opcionTres.setBackground(new Color(248, 103, 103));
		ImageIcon logOutIcon = new ImageIcon("src/cerrarSesionIcon.png");
		opcionTres.setIcon(logOutIcon);
		listaDeOpciones.add(opcionTres);
		
		//Lista del usuario
		JMenu listaDeUsuario = new JMenu("Usuarios");
		listaDeUsuario.setFont(new Font("Yu Gothic UI Semibold",0,16));
		listaDeUsuario.setForeground(Color.WHITE);
		ImageIcon usuarioIcon = new ImageIcon("src/cuentaIcon.png");
		listaDeUsuario.setIcon(usuarioIcon);
		menu.add(listaDeUsuario);
		
		JMenuItem listaUsser = new JMenuItem("Lista de usuarios");
		listaUsser.setFont(new Font("Yu Gothic UI Semibold",0,13));
		listaUsser.setForeground(Color.white);
		listaUsser.setBackground(new Color(125, 221, 229));
		ImageIcon listaUsuarioIcon = new ImageIcon("src/listaUsuarioIcon.png");
		listaUsser.setIcon(listaUsuarioIcon);
		listaDeUsuario.add(listaUsser);
		
		JMenuItem nuevoUsuario = new JMenuItem("Crear usuario");
		nuevoUsuario.setFont(new Font("Yu Gothic UI Semibold",0,13));
		nuevoUsuario.setForeground(Color.white);
		nuevoUsuario.setBackground(new Color(137, 202, 166 ));
		listaDeUsuario.add(nuevoUsuario);
		newcuentaIcon = new ImageIcon("src/agregarUsuarioresol.png");
		nuevoUsuario.setIcon(newcuentaIcon);
	
		//Lista de la ayuda
		JMenu listaDeAyuda = new JMenu("Ayuda");
		ImageIcon ayudaIcon = new ImageIcon("src/ayudaIcon2.png");
		listaDeAyuda.setFont(new Font("Yu Gothic UI Semibold",0,16));
		listaDeAyuda.setForeground(Color.WHITE);
		listaDeAyuda.setIcon(ayudaIcon);
		menu.add(listaDeAyuda);
		
		JMenuItem ayudaCuenta = new JMenuItem("¿Como crear un Usuario?");
		ayudaCuenta.setFont(new Font("Yu Gothic UI Semibold",0,13));
		ayudaCuenta.setForeground(Color.white);
		ayudaCuenta.setBackground(new Color(230, 200, 30));
		ImageIcon howCuentaIcon = new ImageIcon("src/howAccoutIcon.png");
		ayudaCuenta.setIcon(howCuentaIcon);
		listaDeAyuda.add(ayudaCuenta);
		
		JMenuItem ayudaBloqueo = new JMenuItem("¿Como bloquear mi cuenta?");
		ayudaBloqueo.setFont(new Font("Yu Gothic UI Semibold",0,13));
		ayudaBloqueo.setForeground(Color.white);
		ayudaBloqueo.setBackground(new Color(250, 90, 99));
		ImageIcon helpBloqueoCuentaIcon = new ImageIcon("src/howBlockIcon.png");
		ayudaBloqueo.setIcon(helpBloqueoCuentaIcon);
		listaDeAyuda.add(ayudaBloqueo);
		
		ayudaCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"","Como crear una cuenta",
				JOptionPane.OK_OPTION,new ImageIcon("src/Tutorial como crear cuenta 2.png") );
			}
		});
		
		ayudaBloqueo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null,"","Bloquear cuenta",
				JOptionPane.OK_OPTION,new ImageIcon("src/tutoBloquear.png") );
			}
		});
		
		this.setJMenuBar(menu);
		
		//Cambiar panel hacia mi cuenta
		opcionUno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana.this.cambiarPanel("panelUno");
			}
			
		});
		
		//Cambiar panel hacia bloquear 
		opcionDos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana.this.cambiarPanel("panelDos");
			}
		});
	
		opcionTres.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana.this.cambiarPanel("panelTres");
			}
			
		});
			
		listaUsser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana.this.cambiarPanel("panelCuatro");
			}
			
			
		});
		nuevoUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Ventana.this.cambiarPanel("panelCinco");
			}
		});
		
		this.splash();
		this.login();
		//this.newUsuario();
		//this.rellenaPanelUno();
		//this.rellenaPanelDos();
		//this.registro();
		this.validate();
		this.repaint();
	
	}

	public void login() {
		
		JLabel QuackBank, Company,etiquetaNombreUsuario, etiquetaContrasena,etiquetaIniciarSesion;
		JTextField cajaTextoUsuario;
	
		panelActivo = "panelTres";
		
		//Creacion del panel centrado en login de usuarios
		loginUsuarios = new JPanel();
		loginUsuarios.setBounds(0, 0, 400,630 );
		loginUsuarios.setLayout(null);
		loginUsuarios.setBackground(new Color(73, 216, 255  ));
		this.add(loginUsuarios);
		
		QuackBank = new JLabel("QuackBank");
		QuackBank.setBounds(120, 110, 300, 100);
		QuackBank.setFont(new Font("Segoe UI Semibold",0,30));
		QuackBank.setForeground(Color.WHITE);
		loginUsuarios.add(QuackBank);
		
		Company = new JLabel("Company");
		Company.setBounds(155, 130, 300, 100);
		Company.setFont(new Font("Yu Gothic UI Semilight",0,20));
		Company.setForeground(Color.WHITE);
		loginUsuarios.add(Company);
		
		ImageIcon logodeLogin = new ImageIcon("src/pngegg.png");
		JLabel etiquetaImagen = new JLabel(); 
		etiquetaImagen.setBounds(130, -175 ,512 ,512);
		etiquetaImagen.setIcon(new ImageIcon(logodeLogin.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
		loginUsuarios.add(etiquetaImagen);
		
		etiquetaIniciarSesion = new JLabel("Iniciar sesion");
		etiquetaIniciarSesion.setBounds(110,180,200,100);
		etiquetaIniciarSesion.setFont(new Font("Segoe UI Semibold",0,30));
		etiquetaIniciarSesion.setForeground(Color.WHITE);
		loginUsuarios.add(etiquetaIniciarSesion);
		
		etiquetaNombreUsuario = new JLabel("Nombre de Usuario: ");
		etiquetaNombreUsuario.setBounds(70, 220, 200, 100);
		etiquetaNombreUsuario.setFont(new Font("Yu Gothic UI Semibold",0,20));
		etiquetaNombreUsuario.setForeground(Color.WHITE);
		loginUsuarios.add(etiquetaNombreUsuario);
		
		//Ingresar la caja texto del usuario
		cajaTextoUsuario = new JTextField();
		cajaTextoUsuario.setBounds(70, 285, 250, 30);
		loginUsuarios.add(cajaTextoUsuario);
		
		etiquetaContrasena = new JLabel("Contrasena de Acceso:");
		etiquetaContrasena.setBounds(70, 280, 230, 100);
		etiquetaContrasena.setFont(new Font("Yu Gothic UI Semibold",0,20));
		etiquetaContrasena.setForeground(Color.WHITE);
		loginUsuarios.add(etiquetaContrasena);
		
		JPasswordField cajaPassword = new JPasswordField();
		cajaPassword.setBounds(70, 345, 250, 30);
		loginUsuarios.add(cajaPassword);
		
		JButton btn1 = new JButton("Iniciar sesion");
		btn1.setBounds(200, 380, 120,50 );
		btn1.setBackground(new Color(78, 187, 28 ));
		btn1.setFont(new Font("Yu Gothic UI Semibold",0,13));
		btn1.setForeground(Color.WHITE);
		loginUsuarios.add(btn1);
		
		JButton btn2 = new JButton("Cancelar");
		btn2.setBounds(70, 380, 120,50 );
		btn2.setBackground(new Color(254, 62, 0));
		btn2.setFont(new Font("Yu Gothic UI Semibold",0,13));
		btn2.setForeground(Color.WHITE);
		loginUsuarios.add(btn2);
		
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					FileReader registro = new FileReader("src/registro.txt");
					String base_de_datos = "";
					
					try {
						int contenido = registro.read();
						while( contenido != -1 ) {
							
							//System.out.println((char) contenido);
							
							base_de_datos += (char) contenido; 
							contenido = registro.read();
						}

						//System.out.println(base_de_datos);
						
						String[] arreglo = base_de_datos.split("%");
						
						//System.out.println(arreglo[0]);
						
						String[][] records = Ventana.this.stringToMatrix(arreglo);
						Boolean login = false;
						
						for(int i = 0; i < ( arreglo.length/7 )+1; i++) {  
								
							System.out.println(cajaTextoUsuario.getText());
							System.out.println(records[i][1]);
							
							System.out.println("---------------------------");
							
							if(records[i][1].replaceAll(" ", "").equals( cajaTextoUsuario.getText() ) ) {
								
								if(records[i][2].replaceAll(" ", "").equals( cajaPassword.getText() ) ) {
									
									JOptionPane.showMessageDialog(null, "Acceso correcto","Login",JOptionPane.WARNING_MESSAGE,new ImageIcon("src/aprobado.png"));

									Ventana.this.remove(loginUsuarios); 
									Ventana.this.rellenaPanelUno();
									
									login = true;
								}
							}
						}
						
						if(login == false) {
							JLabel label = new JLabel("No se encontro coincidencia");
							label.setFont(new Font("Arial", Font.BOLD, 18));
							JOptionPane.showMessageDialog(null,label,"Error",JOptionPane.YES_OPTION, new ImageIcon("src/Rechazado.png"));
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Ventana.this.validate();
				Ventana.this.repaint();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int opcion = JOptionPane.showConfirmDialog(null,"¿Estas seguro de cerrar la aplicacion?", "Advertencia",JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION ) {
				Ventana.this.dispose();
				}
			}
		});
		
		System.out.println("3");
	}
	
protected String[][] stringToMatrix(String[] arreglo) {
		// TODO Auto-generated method stub
		int r = 0, c = 0;
		
		String[][] records = new String [ ( arreglo.length/7 )+1 ][7]; 
		
		for (String element : arreglo) { 
			
			records[r][c] = element;
			c++;
			if(c == 7) { c=0; r++;}  
			
		}
		
		return records;

	}

	
public void newUsuario() {
		
		panelActivo = "panelCinco";
		
		JLabel etiTitulo, etiNombre,etiUsuario, etiEmail, etiContrasena, etiDescripcion,eticonfContrasena
		,etiComida, etiColor; 
		JTextField setNombre, setUsuario, setEmail;
		JPasswordField contrasena,confContrasena;
		JTextArea setDescripcion;
		JCheckBox opcionUno,opcionDos,opcionTres;
		JRadioButton opUno, opDos, opTres;
		ButtonGroup opciones;
		
		//Crea el panel de creacion de la crear Usuario
		crearUsuario = new JPanel();
		crearUsuario.setBounds(0, 0, 400,630);
		crearUsuario.setLayout(null);
		crearUsuario.setBackground(new Color(104, 211, 146 ));
		this.add(crearUsuario);
	
		ImageIcon logodeAgregarUsuario = new ImageIcon("src/perfil.png");
		JLabel etiquetaImagen1 = new JLabel(); 
		etiquetaImagen1.setBounds(150, -190, 512, 512);
		etiquetaImagen1.setIcon(new ImageIcon(logodeAgregarUsuario.getImage().getScaledInstance(90,90 , Image.SCALE_SMOOTH)));
		crearUsuario.add(etiquetaImagen1);
		
		etiTitulo = new JLabel("Crear Usuario");
		etiTitulo.setBounds(105, -35, 250, 100);
		etiTitulo.setFont(new Font("Segoe UI Semibold",0,30));
		etiTitulo.setForeground(Color.WHITE);
		crearUsuario.add(etiTitulo);
		
		etiNombre = new JLabel("Nombre:");
		etiNombre.setBounds(50, 53, 100, 100);	
		etiNombre.setFont(new Font("Segoe UI Semibold",0,15));
		etiNombre.setForeground(Color.WHITE);
		crearUsuario.add(etiNombre);
		
		setNombre = new JTextField();
		setNombre.setBounds(50, 115, 290, 25);		
		crearUsuario.add(setNombre);
		
		etiUsuario = new JLabel("Usuario:");
		etiUsuario.setBounds(50, 98, 100, 100);	
		etiUsuario.setFont(new Font("Segoe UI Semibold",0,15));
		etiUsuario.setForeground(Color.WHITE);
		crearUsuario.add(etiUsuario);
		
		setUsuario = new JTextField();
		setUsuario.setBounds(50, 160, 290, 25);		
		crearUsuario.add(setUsuario);
		
		etiEmail = new JLabel("Email:");
		etiEmail.setBounds(50, 142, 100, 100);	
		etiEmail.setFont(new Font("Segoe UI Semibold",0,15));
		etiEmail.setForeground(Color.WHITE);
		crearUsuario.add(etiEmail);
		
		setEmail = new JTextField();
		setEmail.setBounds(50, 202, 290, 25);		
		crearUsuario.add(setEmail);
		
		etiContrasena = new JLabel("Contrasena:");
		etiContrasena.setBounds(50, 185, 150, 100);	
		etiContrasena.setFont(new Font("Segoe UI Semibold",0,15));
		etiContrasena.setForeground(Color.WHITE);
		crearUsuario.add(etiContrasena);
		
		contrasena = new JPasswordField();
		contrasena.setBounds(50, 246, 290, 25);
		crearUsuario.add(contrasena);
		
		eticonfContrasena = new JLabel("Confrimar contrasena:");
		eticonfContrasena.setBounds(50, 230, 200, 100);	
		eticonfContrasena.setFont(new Font("Segoe UI Semibold",0,15));
		eticonfContrasena.setForeground(Color.WHITE);
		crearUsuario.add(eticonfContrasena);
		
		confContrasena = new JPasswordField();
		confContrasena.setBounds(50, 290, 290, 25);
		crearUsuario.add(confContrasena);
		
		etiDescripcion = new JLabel("Descripcion:");
		etiDescripcion.setBounds(50, 273, 150, 100);	
		etiDescripcion.setFont(new Font("Segoe UI Semibold",0,15));
		etiDescripcion.setForeground(Color.WHITE);
		crearUsuario.add(etiDescripcion);
		
		setDescripcion = new JTextArea ();
		setDescripcion.setBounds(50, 335, 290, 40);
		crearUsuario.add(setDescripcion);
		
		etiComida = new JLabel("Comida favorita:");
		etiComida.setBounds(50, 335, 220, 100);	
		etiComida.setFont(new Font("Segoe UI Semibold",0,15));
		etiComida.setForeground(Color.WHITE);
		crearUsuario.add(etiComida);
		
		//Seleccionar de color tanto 1 o de 3
		opcionUno = new JCheckBox("Pizza");
		opcionUno.setBounds(50, 400, 60, 30);
		opcionUno.setFont(new Font("Segoe UI Semibold",0,10));
		opcionUno.setForeground(Color.black);
		crearUsuario.add(opcionUno);
		
		opcionDos = new JCheckBox("Asada");
		opcionDos.setBounds(170, 400, 60, 30);
		opcionDos.setFont(new Font("Segoe UI Semibold",0,10));
		opcionDos.setForeground(Color.black);
		crearUsuario.add(opcionDos);
		
		opcionTres = new JCheckBox("Sushi");
		opcionTres.setBounds(280, 400, 60, 30);
		opcionTres.setFont(new Font("Segoe UI Semibold",0,10));
		opcionTres.setForeground(Color.black);
		crearUsuario.add(opcionTres);
		
		//Opcion del color
		etiColor = new JLabel("Color favorito:");
		etiColor.setBounds(50, 390, 220, 100);	
		etiColor.setFont(new Font("Segoe UI Semibold",0,15));
		etiColor.setForeground(Color.WHITE);
		crearUsuario.add(etiColor);
		
		opUno = new JRadioButton("Azul");
		opUno.setBounds(50, 450, 60, 30);
		opUno.setFont(new Font("Segoe UI Semibold",0,10));
		opUno.setForeground(Color.black);
		crearUsuario.add(opUno);
		
		opDos = new JRadioButton("Rojo");
		opDos.setBounds(170, 450, 60, 30);
		opDos.setFont(new Font("Segoe UI Semibold",0,10));
		opDos.setForeground(Color.black);
		crearUsuario.add(opDos);
		
		opTres = new JRadioButton("Verde");
		opTres.setBounds(280, 450, 60, 30);
		opTres.setFont(new Font("Segoe UI Semibold",0,10));
		opTres.setForeground(Color.black);
		crearUsuario.add(opTres);
		
		JButton btn1 = new JButton("Registrar");
		btn1.setBackground(new Color(231, 142, 22 ));
		btn1.setFont(new Font("Yu Gothic UI Semibold",0,17));
		btn1.setForeground(Color.WHITE);
	    btn1.setBounds(135, 490, 120, 50);
	    
	    crearUsuario.add(btn1);
	    
	    btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
				String clave1 = contrasena.getText();
				String clave2 = confContrasena.getText();
				System.out.println(clave1);
				System.out.println(clave2);
			
				String strName = setNombre.getText();
				String strUser = setUsuario.getText();
				String strMail = setEmail.getText();
				String strBio = setDescripcion.getText();
				String strPwd  = contrasena.getText(); 
				String plates = "";
				String color = "";
				
				if(clave2.equals(clave1)) {
					
					plates += ( opcionUno.isSelected() )? opcionUno.getText()+" " : "";
					if( opcionDos.isSelected() )  plates += opcionDos.getText()+" ";
					if( opcionTres.isSelected() ) plates += opcionTres.getText()+" ";
					
					if( opUno.isSelected() ) color = opUno.getText();
					if( opDos.isSelected() ) color = opDos.getText();
					if( opTres.isSelected() ) color = opTres.getText();
					
					System.out.println( strPwd );
					
					try {
						FileWriter teclado = new FileWriter("src/registro.txt",true);
						String texto = ""+ strName +"%"+strUser+"%"+strPwd+"%"+ strMail +"%"+ strBio +"%"+ plates +"%"+color+"%";

						teclado.append("\n"+ texto );
						teclado.flush(); 
						teclado.close();
						
						JOptionPane alertaUno = new JOptionPane();
						alertaUno.showMessageDialog(btn1, "Usuario registrado","Éxito",JOptionPane.OK_OPTION,new ImageIcon("src/aprobado.png") );
						
						setNombre.setText("");
						setUsuario.setText("");
						setEmail.setText("");
						setDescripcion.setText("");
						contrasena.setText(""); 
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					System.out.println("Acceso de negado");
					JOptionPane.showMessageDialog(null,"Confirme bien con su contraseña", "Confirmación", 
							JOptionPane.CLOSED_OPTION,new ImageIcon("src/rechazadoIcon.png"));
				}		
			}	    		
	    });
	}	
	
public void splash() {
		
		JLabel etiQuackBank, etiCompany,byJose;
		pantallaCarga = new JPanel();
		pantallaCarga.setBounds(0, 0, 400,630);
		pantallaCarga.setLayout(null);
		pantallaCarga.setBackground(new Color(176, 111, 213 ));
		this.add(pantallaCarga);
		
		ImageIcon logoDePantalla = new ImageIcon("src/pngegg.png");
		JLabel etiquetaImagenLogo = new JLabel(); 
		etiquetaImagenLogo.setBounds(96, -50 ,512 ,512);
		etiquetaImagenLogo.setIcon(new ImageIcon(logoDePantalla.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		pantallaCarga.add(etiquetaImagenLogo);
		
		etiQuackBank = new JLabel("QuackBank");
		etiQuackBank.setBounds(98, 275, 300, 100);
		etiQuackBank.setFont(new Font("Segoe UI Semibold",0,40));
		etiQuackBank.setForeground(Color.WHITE);
		pantallaCarga.add(etiQuackBank);
		
		etiCompany = new JLabel("Company");
		etiCompany.setBounds(155, 300, 300, 100);
		etiCompany.setFont(new Font("Yu Gothic UI Semilight",0,20));
		etiCompany.setForeground(Color.WHITE);
		pantallaCarga.add(etiCompany);
		
		byJose = new JLabel("Made by Jose Manuel Benitez");
		byJose.setBounds(73, 490, 300, 100);
		byJose.setFont(new Font("Yu Gothic UI Semilight",0,20));
		byJose.setForeground(Color.WHITE);
		pantallaCarga.add(byJose);
		
		
		JProgressBar barra = new JProgressBar(0,100);
		barra.setBounds(72, 370, 250, 30);
		barra.setBackground(new Color(247, 106, 74 ));
		barra.setFont(new Font("Segoe UI Semibold",0,15));
		barra.setForeground(new Color(236, 194, 74));
		pantallaCarga.add(barra);
		
		barra.setStringPainted(true);
		
		int i= 0;
		while(i<=100) {
			barra.setValue(i);
			try {
				Thread.sleep(20);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		if(i >= 100){	
			System.out.println("Hola");
			this.remove(pantallaCarga);
			this.repaint();
			this.validate();		
		}
	}

public void cerrarVentana() {
	try {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				confirmarVentana();
			}
			
		});
		this.setVisible(true);
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public void confirmarVentana() {
	
	int valor = JOptionPane.showConfirmDialog(this,"¿Estas seguro de cerrar la aplicacion?", "Advertencia",JOptionPane.YES_NO_OPTION);
	if(valor == JOptionPane.YES_OPTION) {
		JOptionPane.showMessageDialog(null,"Gracias por utilizarnos, hasta pronto","Gracias", JOptionPane.INFORMATION_MESSAGE, 
		new ImageIcon("src/despedidaIcon.png"));
		System.exit(0);
	}
	
}

	
public void cambiarPanel(String target){
		//Remover los paneles
	if(panelActivo.equals("panelUno") ){
	Ventana.this.remove(panelviewPerfil);
	}
	
	if(panelActivo.equals("panelDos")) {
		Ventana.this.remove(panelBloquear);
	}
	if(panelActivo.equals("panelTres") ){
	Ventana.this.remove(loginUsuarios);
	}
	if(panelActivo.equals("panelCuatro") ){
	Ventana.this.remove(panelRegistro);
		}
	if(panelActivo.equals("panelCinco") ){
		Ventana.this.remove(crearUsuario);
			}
	
	//Para añadir panales
	if(target.equals("panelUno")) {
	Ventana.this.rellenaPanelUno();
	}	
	if(target.equals("panelDos")) {
	Ventana.this.rellenaPanelDos();
	}
	if(target.equals("panelTres")) {
	Ventana.this.login();
	}
	if(target.equals("panelCuatro")) {
	Ventana.this.registro();
	}
	if(target.equals("panelCinco")) {
	Ventana.this.newUsuario();
		}
	
	
	Ventana.this.validate();
	Ventana.this.repaint();
}
	
public void rellenaPanelUno() {
	JLabel etiPerfil,etiNombre,etiUsuario,etiEmail,etiContrasena, etiDescripcion,etiComida,etiColor;
	JTextField setNombre2, setUsuario2, setEmail2;
	JPasswordField contrasena2;
	JTextArea setDescripcion2;
	JCheckBox opcionUno,opcionDos,opcionTres;
	JRadioButton opUno, opDos, opTres;
	ButtonGroup opciones;
	
	panelActivo = "panelUno";
	
	panelviewPerfil = new JPanel();
	panelviewPerfil.setBounds(0, 0, 400,630);
	panelviewPerfil.setLayout(null);
	panelviewPerfil.setBackground(new Color(202, 214, 114));
	Ventana.this.add(panelviewPerfil);
	
	ImageIcon logoViewPerfil = new ImageIcon("src/viewperfilIcon.png"); 
	JLabel ajusteImage = new JLabel();
	ajusteImage.setBounds(155, -170, 512, 512);
	ajusteImage.setIcon(new ImageIcon(logoViewPerfil.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
	panelviewPerfil.add(ajusteImage);
	
	etiPerfil = new JLabel("Mi cuenta");
	etiPerfil.setBounds(123, -30, 250, 100);
	etiPerfil.setFont(new Font("Segoe UI Semibold",0,30));
	etiPerfil.setForeground(Color.WHITE);
	panelviewPerfil.add(etiPerfil);
	
	etiNombre = new JLabel("Nombre:");
	etiNombre.setBounds(50, 95, 250, 100);
	etiNombre.setFont(new Font("Segoe UI Semibold",0,13));
	etiNombre.setForeground(Color.WHITE);
	panelviewPerfil.add(etiNombre);
	
	setNombre2 = new JTextField();
	setNombre2.setBounds(50, 155, 290, 25);		
	panelviewPerfil.add(setNombre2);
	
	etiUsuario= new JLabel("Usuario:");
	etiUsuario.setBounds(50, 140, 250, 100);
	etiUsuario.setFont(new Font("Segoe UI Semibold",0,13));
	etiUsuario.setForeground(Color.WHITE);
	panelviewPerfil.add(etiUsuario);
	
	setUsuario2 = new JTextField();
	setUsuario2.setBounds(50, 200, 290, 25);		
	panelviewPerfil.add(setUsuario2);
	
	etiEmail = new JLabel("Email:");
	etiEmail.setBounds(50, 185, 250, 100);
	etiEmail.setFont(new Font("Segoe UI Semibold",0,13));
	etiEmail.setForeground(Color.WHITE);
	panelviewPerfil.add(etiEmail);
	
	setEmail2 = new JTextField();
	setEmail2.setBounds(50, 245, 290, 25);		
	panelviewPerfil.add(setEmail2);
	
	etiContrasena = new JLabel("Contraseña:");
	etiContrasena.setBounds(50, 230, 250, 100);
	etiContrasena.setFont(new Font("Segoe UI Semibold",0,13));
	etiContrasena.setForeground(Color.WHITE);
	panelviewPerfil.add(etiContrasena);
	
	contrasena2 = new JPasswordField();
	contrasena2.setBounds(50, 290, 290,25);		
	panelviewPerfil.add(contrasena2);
	
	etiDescripcion = new JLabel("Descripción:");
	etiDescripcion.setBounds(50, 275, 250, 100);
	etiDescripcion.setFont(new Font("Segoe UI Semibold",0,13));
	etiDescripcion.setForeground(Color.WHITE);
	panelviewPerfil.add(etiDescripcion);
	
	setDescripcion2 = new JTextArea();
	setDescripcion2.setBounds(50, 335, 290, 50);
	panelviewPerfil.add(setDescripcion2);
	
	etiComida = new JLabel("Comida favorita:");
	etiComida.setBounds(50, 345, 250, 100);
	etiComida.setFont(new Font("Segoe UI Semibold",0,13));
	etiComida.setForeground(Color.WHITE);
	panelviewPerfil.add(etiComida);
	
	opcionUno = new JCheckBox("Pizza");
	opcionUno.setBounds(50, 405, 60, 30);
	opcionUno.setFont(new Font("Segoe UI Semibold",0,10));
	opcionUno.setForeground(Color.black);
	panelviewPerfil.add(opcionUno);
	
	opcionDos = new JCheckBox("Asada");
	opcionDos.setBounds(170, 405, 60, 30);
	opcionDos.setFont(new Font("Segoe UI Semibold",0,10));
	opcionDos.setForeground(Color.black);
	panelviewPerfil.add(opcionDos);
	
	opcionTres = new JCheckBox("Sushi");
	opcionTres.setBounds(280, 405, 60, 30);
	opcionTres.setFont(new Font("Segoe UI Semibold",0,10));
	opcionTres.setForeground(Color.black);
	panelviewPerfil.add(opcionTres);
	
	etiColor = new JLabel("Color favorito:");
	etiColor.setBounds(50, 395, 220, 100);	
	etiColor.setFont(new Font("Segoe UI Semibold",0,15));
	etiColor.setForeground(Color.WHITE);
	panelviewPerfil.add(etiColor);
	
	opUno = new JRadioButton("Azul");
	opUno.setBounds(50, 455, 60, 30);
	opUno.setFont(new Font("Segoe UI Semibold",0,10));
	opUno.setForeground(Color.black);
	panelviewPerfil.add(opUno);
	
	opDos = new JRadioButton("Rojo");
	opDos.setBounds(170, 455, 60, 30);
	opDos.setFont(new Font("Segoe UI Semibold",0,10));
	opDos.setForeground(Color.black);
	panelviewPerfil.add(opDos);
	
	opTres = new JRadioButton("Verde");
	opTres.setBounds(280, 455, 60, 30);
	opTres.setFont(new Font("Segoe UI Semibold",0,10));
	opTres.setForeground(Color.black);
	panelviewPerfil.add(opTres);
	
	JButton btn1 = new JButton("Editar");
	btn1.setBackground(new Color(231, 142, 22 ));
	btn1.setFont(new Font("Yu Gothic UI Semibold",0,17));
	btn1.setForeground(Color.WHITE);
    btn1.setBounds(135, 495, 120, 50);
	panelviewPerfil.add(btn1);
	
	
	System.out.println("1");
}





public void rellenaPanelDos() {
	
	JLabel etiBloqueo, etiContrasena;
	JPasswordField confirmContrasena;
	
	panelActivo = "panelDos";
	
	panelBloquear = new JPanel();
	panelBloquear.setLayout(null);
	panelBloquear.setBounds(0, 0, 400,630);
	panelBloquear.setBackground(new Color(188, 151, 229));
	Ventana.this.add(panelBloquear);
	
	ImageIcon logodeBloquear = new ImageIcon("src/bloquear.png");
	JLabel etiquetaImagen1 = new JLabel(); 
	etiquetaImagen1.setBounds(97, -70, 512, 512);
	etiquetaImagen1.setIcon(new ImageIcon(logodeBloquear.getImage().getScaledInstance(200,200 , Image.SCALE_SMOOTH)));
	panelBloquear.add(etiquetaImagen1);
	
	etiBloqueo = new JLabel("Cuenta bloqueada");
	etiBloqueo.setBounds(30, -10, 330, 100);
	etiBloqueo.setFont(new Font("Segoe UI Semibold",0,40));
	etiBloqueo.setForeground(Color.WHITE);
	panelBloquear.add(etiBloqueo);
	
	etiContrasena = new JLabel("Confirme su contraseña");
	etiContrasena.setBounds(60, 280, 330, 100);
	etiContrasena.setFont(new Font("Segoe UI Semibold",0,25));
	etiContrasena.setForeground(Color.WHITE);
	panelBloquear.add(etiContrasena);
	
	confirmContrasena = new JPasswordField();
	confirmContrasena.setBounds(60,350,270,30);
	panelBloquear.add(confirmContrasena);
	
	JButton bt1 = new JButton("Confirmar");
	bt1.setBounds(135, 390, 120, 50);
	bt1.setBackground(new Color(250, 61, 61));
	bt1.setFont(new Font("Segoe UI Semibold",0,15));
	bt1.setForeground(Color.WHITE);
	panelBloquear.add(bt1);
	
	System.out.println("2");
	
}

public void registro() {
	
	panelActivo = "panelCuatro";
	
	panelRegistro = new JPanel();
	panelRegistro.setBounds(0, 0, 400, 630);
	panelRegistro.setLayout(null);
	panelRegistro.setBackground(new Color(138, 219, 203));
	Ventana.this.add(panelRegistro);
	
	
	System.out.println("4");
}

}


