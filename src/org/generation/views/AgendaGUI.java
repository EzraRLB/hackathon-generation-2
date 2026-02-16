package org.generation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.generation.models.Agenda;
import org.generation.models.Contacto;

public class AgendaGUI extends JFrame {
    
    // Componentes de la interfaz
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextArea areaContactos;
    private JLabel lblEspacios;
    private Agenda agenda;
    
    public AgendaGUI() {
        // Crear la agenda con tamaño por defecto (10)
        agenda = new Agenda();
        
        // Configurar la ventana principal
        setTitle("Agenda de Contactos");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setResizable(false);
        
        // Crear el panel principal con padding
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelPrincipal.setBackground(new Color(240, 240, 245));
        
        // ========== PANEL SUPERIOR: Título ==========
        JLabel titulo = new JLabel("AGENDA DE CONTACTOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(new Color(50, 50, 100));
        
        // ========== PANEL DE INPUTS ==========
        JPanel panelInputs = new JPanel(new GridBagLayout());
        panelInputs.setBackground(new Color(240, 240, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Label Nombre
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        panelInputs.add(lblNombre, gbc);
        
        // Campo Nombre
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        txtNombre = new JTextField(20);
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        panelInputs.add(txtNombre, gbc);
        
        // Label Teléfono
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
        panelInputs.add(lblTelefono, gbc);
        
        // Campo Teléfono
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        txtTelefono = new JTextField(20);
        txtTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
        panelInputs.add(txtTelefono, gbc);
        
        // ========== PANEL DE BOTONES ==========
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelBotones.setBackground(new Color(240, 240, 245));
        
        JButton btnAgregar = crearBoton("Agregar", new Color(46, 204, 113));
        JButton btnBuscar = crearBoton("Buscar", new Color(52, 152, 219));
        JButton btnEliminar = crearBoton("Eliminar", new Color(231, 76, 60));
        JButton btnListar = crearBoton("Listar Todos", new Color(155, 89, 182));
        
        panelBotones.add(btnAgregar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnListar);
        
        // ========== ÁREA DE RESULTADOS ==========
        areaContactos = new JTextArea(10, 40);
        areaContactos.setEditable(false);
        areaContactos.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaContactos.setBackground(Color.WHITE);
        areaContactos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane scroll = new JScrollPane(areaContactos);
        scroll.setBorder(BorderFactory.createTitledBorder("Contactos"));
        
        // ========== PANEL INFERIOR: Estado ==========
        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEstado.setBackground(new Color(240, 240, 245));
        lblEspacios = new JLabel("Espacios libres: 10/10");
        lblEspacios.setFont(new Font("Arial", Font.ITALIC, 12));
        panelEstado.add(lblEspacios);
        
        // ========== COMBINAR PANELES ==========
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(240, 240, 245));
        panelCentro.add(panelInputs);
        panelCentro.add(panelBotones);
        
        // Agregar todo al panel principal
        panelPrincipal.add(titulo, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(scroll, BorderLayout.SOUTH);
        
        // Agregar panel principal a la ventana
        add(panelPrincipal);
        
        // ========== ACCIONES DE LOS BOTONES ==========
        
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarContacto();
            }
        });
        
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarContacto();
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarContacto();
            }
        });
        
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarContactos();
            }
        });
        
        // Mostrar mensaje inicial
        areaContactos.setText("¡Bienvenido a la Agenda de Contactos!\n\nUsa los campos de arriba para agregar o buscar contactos.");
    }
    
    // Método auxiliar para crear botones con estilo
    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return boton;
    }
    
    // ========== MÉTODOS QUE CONECTAN CON LA AGENDA ==========
    
    // Agregar contacto
    private void agregarContacto() {
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        
        // Validar campos vacíos
        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor completa todos los campos", 
                "Campos vacíos", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Verificar si la agenda está llena
        if (agenda.agendaLlena()) {
            JOptionPane.showMessageDialog(this, 
                "La agenda está llena. No se pueden agregar más contactos.", 
                "Agenda llena", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crear contacto y agregarlo
        Contacto nuevo = new Contacto(nombre, telefono);
        
        // Verificar si ya existe
        if (agenda.existeContacto(nuevo)) {
            JOptionPane.showMessageDialog(this, 
                "Ya existe un contacto con ese nombre", 
                "Contacto duplicado", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        agenda.añadirContacto(nuevo);
        JOptionPane.showMessageDialog(this, 
            "Contacto agregado exitosamente", 
            "Éxito", 
            JOptionPane.INFORMATION_MESSAGE);
        
        limpiarCampos();
        actualizarEspacios();
    }
    
    // Buscar contacto
    private void buscarContacto() {
        String nombre = txtNombre.getText().trim();
        
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Escribe un nombre para buscar", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Buscar y mostrar resultado
        String telefono = agenda.obtenerTelefono(nombre);
        
        if (telefono != null) {
            areaContactos.setText("=== RESULTADO DE BÚSQUEDA ===\n\n");
            areaContactos.append("Nombre: " + nombre + "\n");
            areaContactos.append("Teléfono: " + telefono + "\n");
        } else {
            areaContactos.setText("Contacto '" + nombre + "' no encontrado.");
        }
    }
    
    // Eliminar contacto
    private void eliminarContacto() {
        String nombre = txtNombre.getText().trim();
        
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Escribe el nombre del contacto a eliminar", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de eliminar a " + nombre + "?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            Contacto c = new Contacto(nombre, "");
            boolean eliminado = agenda.eliminarContacto(c);
            
            if (eliminado) {
                JOptionPane.showMessageDialog(this, 
                    "Contacto eliminado", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                actualizarEspacios();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No se encontró el contacto", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Listar todos los contactos
    private void listarContactos() {
        areaContactos.setText("=== LISTA DE CONTACTOS ===\n\n");
        
        String lista = agenda.obtenerListaContactos();
        
        if (lista.isEmpty()) {
            areaContactos.append("La agenda está vacía.");
        } else {
            areaContactos.append(lista);
        }
        
        areaContactos.append("\n\n------------------------");
        areaContactos.append("\nEspacios libres: " + agenda.espacioLibres());
    }
    
    // Limpiar campos de texto
    private void limpiarCampos() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtNombre.requestFocus();
    }
    
    // Actualizar contador de espacios
    private void actualizarEspacios() {
        int libres = agenda.espacioLibres();
        lblEspacios.setText("Espacios libres: " + libres + "/10");
    }
    
    // ========== MAIN ==========
    public static void main(String[] args) {
        // Ejecutar en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AgendaGUI ventana = new AgendaGUI();
                ventana.setVisible(true);
            }
        });
    }
}
