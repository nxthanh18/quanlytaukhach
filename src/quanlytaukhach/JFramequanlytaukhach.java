/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytaukhach;

import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Date;
import entities.*;
import dulieu.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.table.*;
import java.io.*;

public class JFramequanlytaukhach extends javax.swing.JFrame {

    private List<taukhach> dstk = new ArrayList<taukhach>();
    private taukhachdao tkd = new taukhachdao();
    private taukhach tk = new taukhach();
    private congtyvantaidao ctvtdao = new congtyvantaidao();
    private congtyvantai ctvt = new congtyvantai();
    private List<congtyvantai> dsct = new ArrayList<congtyvantai>();
    private Taikhoandao taikhoandao = new Taikhoandao();
    private List<Taikhoan> dstaikhoan = new ArrayList<Taikhoan>();
    private maquyendao mqd = new maquyendao();
    private List<maquyen> dsquyen = new ArrayList<maquyen>();
    private String hinhanh;
    private Timer timer;
    private Hanhkhachdao hkd = new Hanhkhachdao();
    private List<Hanhkhach> dshk = new ArrayList<Hanhkhach>();
    private Hanhkhach hk = new Hanhkhach();

    public JFramequanlytaukhach() {
        initComponents();
        timer();
        findtk(tkd.findll());
        findct(ctvtdao.findll());
        this.jLabel10hinhanh.setSize(350, 115);

        findquyen();
        findtaikhoan(taikhoandao.findll());
        this.jTextArea1content.setLineWrap(true);
        this.jTextArea1content.setTabSize(100);
        this.jTextArea1content.setDragEnabled(true);
        this.jTextArea1content.setWrapStyleWord(true);
        listgiave();
        comboxmataukhach();
        findhanhkhach(hkd.findll());

    }

    private void findhanhkhach(List<Hanhkhach> dshk) {
        try {
            DefaultTableModel dtm = new DefaultTableModel();

            dtm.addColumn("ma Hanh khach");
            dtm.addColumn("Ten hanh khach");
            dtm.addColumn("So dien thoai");
            dtm.addColumn("Giay chung minh");
            dtm.addColumn("Ma tau khach");

            for (Hanhkhach hk : dshk) {
                dtm.addRow(new Object[]{hk.getMahk(), hk.getTenhk(), hk.getSdt(), hk.getGiaycm(), hk.getMatk()});
            }

            this.jTable2danhsachhanhkhach.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void comboxmataukhach() {
        this.dstk = tkd.findll();
        for (taukhach tk : this.dstk) {
            this.jComboBox1mataukhach.addItem(tk.getMatk());
        }

    }

    private void listgiave() {
        DefaultListModel dlm = new DefaultListModel();
        for (taukhach tk : tkd.findll()) {
            dlm.addElement(tk.getGiave());
        }

    }

    public void ganquyen(Taikhoan taik) {
        if (taik.getMaquyen().equalsIgnoreCase("employee")) {

            JOptionPane.showMessageDialog(null, "employee login");

        } else {
            JOptionPane.showMessageDialog(null, "admin login");
        }
    }

    private void findtaikhoan(List<Taikhoan> dstk) {
        try {
            DefaultTableModel dtm = new DefaultTableModel();

            dtm.addColumn("Username");
            dtm.addColumn("Password");
            dtm.addColumn("Ho ten");
            dtm.addColumn("Email");
            dtm.addColumn("Ma quyen");

            for (Taikhoan taik : dstk) {
                dtm.addRow(new Object[]{taik.getUsername(), taik.getPassword(), taik.getHoten(), taik.getHoten(), taik.getMaquyen()});
            }

            this.jTable1danhsachtaikhoan.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void findquyen() {
        this.dsquyen = mqd.findll();
        for (maquyen mq : this.dsquyen) {
            this.jComboBox1mauquyen.addItem(mq.getTenquyen());
        }
    }

    public void timer() {
        this.timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                java.util.Calendar c = java.util.Calendar.getInstance();
                c.setTime(new java.util.Date());
                String t = c.get(java.util.Calendar.HOUR) + " : " + c.get(java.util.Calendar.MINUTE) + " : " + c.get(java.util.Calendar.SECOND);
                String date = c.get(java.util.Calendar.DAY_OF_MONTH) + " / " + (c.get(java.util.Calendar.MONTH) + 1) + " / " + c.get(java.util.Calendar.YEAR);
                jLabel2time.setText(t);
                jLabel2date.setText(date);
            }
        });

        this.timer.start();
    }

    private void findtk(List<taukhach> dstk) {
        try {
            DefaultTableModel dtm = new DefaultTableModel();

            dtm.addColumn("Ma tau khach");
            dtm.addColumn("Ten tau khach");
            dtm.addColumn("thien truong");
            dtm.addColumn("Tuyen duong");
            dtm.addColumn("Toc do");
            dtm.addColumn("Gia ve");
            dtm.addColumn("Hinh anh");
            dtm.addColumn("Ma cong ty");
            for (taukhach tk : dstk) {
                dtm.addRow(new Object[]{tk.getMatk(), tk.getTentk(), tk.getThientruong(), tk.getTuyenduong(), tk.getTocdo(), tk.getGiave(), tk.getHinhanh(), tk.getMact()});
            }

            this.jTable1taukhach.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void findct(List<congtyvantai> dsct) {
        try {
            DefaultTableModel dtm = new DefaultTableModel();
            dtm.addColumn("ma cong ty");
            dtm.addColumn("ten cong ty");
            dtm.addColumn("so dien thoai");
            dtm.addColumn("dia chi");
            dtm.addColumn("giam doc dieu hanh");
            for (congtyvantai ctvt : dsct) {
                dtm.addRow(new Object[]{ctvt.getMact(), ctvt.getTenct(), ctvt.getSdt(), ctvt.getDiachi(), ctvt.getGiamdocdh()});
            }
            this.jTable1congtyvantai.setModel(dtm);
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2time = new javax.swing.JLabel();
        jLabel2date = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1matk = new javax.swing.JTextField();
        jTextField2tentk = new javax.swing.JTextField();
        jTextField3thientruong = new javax.swing.JTextField();
        jTextField4tuyenduong = new javax.swing.JTextField();
        jTextField5tocdo = new javax.swing.JTextField();
        jTextField6giave = new javax.swing.JTextField();
        jTextField7mact = new javax.swing.JTextField();
        jLabel10hinhanh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1taukhach = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jTextField1search = new javax.swing.JTextField();
        jButton1search = new javax.swing.JButton();
        jButton1them = new javax.swing.JButton();
        jButton2capnhap = new javax.swing.JButton();
        jButton3clearn = new javax.swing.JButton();
        jButton1bromse = new javax.swing.JButton();
        jButton1delete = new javax.swing.JButton();
        jPanel4danhsachcongty = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2macongty = new javax.swing.JTextField();
        jTextField3tenct = new javax.swing.JTextField();
        jTextField4sdt = new javax.swing.JTextField();
        jTextField5diachi = new javax.swing.JTextField();
        jTextField6giamdocdieuhanh = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1congtyvantai = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jButton1themct = new javax.swing.JButton();
        jButton1capnhapct = new javax.swing.JButton();
        jButton2deletect = new javax.swing.JButton();
        jButton3clearnct = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1content = new javax.swing.JTextArea();
        jButton1save = new javax.swing.JButton();
        jButton2open = new javax.swing.JButton();
        jPanel3danhsachtaikhoan = new javax.swing.JPanel();
        jButton1insert = new javax.swing.JButton();
        jButton2delete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jTextField1username = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField2password = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField3hoten = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField4email = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1mauquyen = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1danhsachtaikhoan = new javax.swing.JTable();
        jButton1clearn = new javax.swing.JButton();
        jButton1update = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField1mahk = new javax.swing.JTextField();
        jTextField2tenhanhkhach = new javax.swing.JTextField();
        jTextField3sodienthoai = new javax.swing.JTextField();
        jTextField4giaychungminh = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jComboBox1mataukhach = new javax.swing.JComboBox();
        jButton1inserthk = new javax.swing.JButton();
        jButton2updatehk = new javax.swing.JButton();
        jButton3deletehk = new javax.swing.JButton();
        jButton1clearnhk = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jComboBox1manam = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jCalendarCombo1ngaysb = new org.freixas.jcalendar.JCalendarCombo();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea1mota = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jComboBox2mataukhach = new javax.swing.JComboBox();
        jComboBox3mahanhkhach = new javax.swing.JComboBox();
        jButton1insertngayxb = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2danhsachhanhkhach = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1danhsachxuatben = new javax.swing.JTable();
        jButton1deletengayxb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("quan ly tau khach");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2time.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2time.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2time.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2date.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2date.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/logout.png"))); // NOI18N
        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2date, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(399, 399, 399)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2time, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(660, 660, 660)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2date, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2time, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Ma tau khach");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Ten tau khach");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Thien truong");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tuyen duong");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Toc do");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Gia ve");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Hinh anh");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Ma cong ty");

        jLabel10hinhanh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1taukhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1taukhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1taukhachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1taukhach);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setText("Danh sach tau khach");

        jTextField1search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1searchKeyPressed(evt);
            }
        });

        jButton1search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_search.png"))); // NOI18N
        jButton1search.setText("Search");
        jButton1search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1searchActionPerformed(evt);
            }
        });

        jButton1them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_add.png"))); // NOI18N
        jButton1them.setText("Them");
        jButton1them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1themActionPerformed(evt);
            }
        });

        jButton2capnhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_save.png"))); // NOI18N
        jButton2capnhap.setText("Cap nhap");
        jButton2capnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2capnhapActionPerformed(evt);
            }
        });

        jButton3clearn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton3clearn.setText("Clearn");
        jButton3clearn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3clearnActionPerformed(evt);
            }
        });

        jButton1bromse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/project_open.png"))); // NOI18N
        jButton1bromse.setText("Bromse");
        jButton1bromse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1bromseActionPerformed(evt);
            }
        });

        jButton1delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton1delete.setText("delete");
        jButton1delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6giave)
                            .addComponent(jTextField5tocdo)
                            .addComponent(jTextField4tuyenduong)
                            .addComponent(jTextField3thientruong)
                            .addComponent(jTextField2tentk)
                            .addComponent(jTextField1matk)
                            .addComponent(jTextField7mact, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(366, 366, 366))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jButton1them)
                                .addGap(42, 42, 42)
                                .addComponent(jButton2capnhap)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1delete)
                                .addGap(31, 31, 31)
                                .addComponent(jButton3clearn)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton1bromse)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel10hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(jTextField1search, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton1search)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1matk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2tentk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3thientruong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4tuyenduong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5tocdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextField6giave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1bromse)))))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jTextField7mact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1them)
                                .addComponent(jButton2capnhap)
                                .addComponent(jButton3clearn)
                                .addComponent(jButton1delete))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1search)
                            .addComponent(jTextField1search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong tin tau khach", jPanel1);

        jPanel4danhsachcongty.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Ma cong ty");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Ten cong ty");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("So dien thoai");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Dia chi");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Giam doc dieu hanh");

        jTable1congtyvantai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1congtyvantai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1congtyvantaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1congtyvantai);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("Danh sach cong ty");

        jButton1themct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_add.png"))); // NOI18N
        jButton1themct.setText("them");
        jButton1themct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1themctActionPerformed(evt);
            }
        });

        jButton1capnhapct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_save.png"))); // NOI18N
        jButton1capnhapct.setText("cap nhap");
        jButton1capnhapct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1capnhapctActionPerformed(evt);
            }
        });

        jButton2deletect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton2deletect.setText("delete");
        jButton2deletect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2deletectActionPerformed(evt);
            }
        });

        jButton3clearnct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton3clearnct.setText("clearn");
        jButton3clearnct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3clearnctActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 0, 102));
        jLabel24.setText("Gi chu");

        jTextArea1content.setColumns(20);
        jTextArea1content.setLineWrap(true);
        jTextArea1content.setRows(5);
        jTextArea1content.setWrapStyleWord(true);
        jScrollPane4.setViewportView(jTextArea1content);

        jButton1save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_save.png"))); // NOI18N
        jButton1save.setText("Save");
        jButton1save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1saveActionPerformed(evt);
            }
        });

        jButton2open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/project_open.png"))); // NOI18N
        jButton2open.setText("Open");
        jButton2open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2openActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4danhsachcongtyLayout = new javax.swing.GroupLayout(jPanel4danhsachcongty);
        jPanel4danhsachcongty.setLayout(jPanel4danhsachcongtyLayout);
        jPanel4danhsachcongtyLayout.setHorizontalGroup(
            jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(100, 100, 100)
                .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField2macongty)
                        .addComponent(jTextField3tenct)
                        .addComponent(jTextField4sdt)
                        .addComponent(jTextField5diachi)
                        .addComponent(jTextField6giamdocdieuhanh, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addComponent(jButton1themct)
                        .addGap(45, 45, 45)
                        .addComponent(jButton1capnhapct)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2deletect)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3clearnct)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4danhsachcongtyLayout.createSequentialGroup()
                            .addComponent(jButton1save)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2open)
                            .addGap(397, 397, 397))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4danhsachcongtyLayout.setVerticalGroup(
            jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField2macongty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel16)))
                .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField3tenct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField4sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextField5diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jLabel24)
                .addGap(19, 19, 19)
                .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4danhsachcongtyLayout.createSequentialGroup()
                        .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField6giamdocdieuhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1themct)
                            .addComponent(jButton1capnhapct)
                            .addComponent(jButton2deletect)
                            .addComponent(jButton3clearnct)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4danhsachcongtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2open)
                    .addComponent(jButton1save))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong Tin cong ty van tai", jPanel4danhsachcongty);

        jButton1insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_add.png"))); // NOI18N
        jButton1insert.setText("insert");
        jButton1insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1insertActionPerformed(evt);
            }
        });

        jButton2delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton2delete.setText("delete");
        jButton2delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2deleteActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dang Ky tai khoan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Username");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Password");

        jTextField3hoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3hotenActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Ho ten");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Email");

        jComboBox1mauquyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1mauquyenActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ma quyen");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jComboBox1mauquyen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField4email, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1username)
                            .addComponent(jTextField3hoten))
                        .addGap(20, 20, 20))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jComboBox1mauquyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(43, 43, 155));
        jLabel23.setText("Danh sach tai khoan");

        jTable1danhsachtaikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1danhsachtaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1danhsachtaikhoanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1danhsachtaikhoan);

        jButton1clearn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton1clearn.setText("Clearn");
        jButton1clearn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1clearnActionPerformed(evt);
            }
        });

        jButton1update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_save.png"))); // NOI18N
        jButton1update.setText("update");
        jButton1update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3danhsachtaikhoanLayout = new javax.swing.GroupLayout(jPanel3danhsachtaikhoan);
        jPanel3danhsachtaikhoan.setLayout(jPanel3danhsachtaikhoanLayout);
        jPanel3danhsachtaikhoanLayout.setHorizontalGroup(
            jPanel3danhsachtaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3danhsachtaikhoanLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3danhsachtaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3danhsachtaikhoanLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(351, 351, 351))
                    .addGroup(jPanel3danhsachtaikhoanLayout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(148, Short.MAX_VALUE))))
            .addGroup(jPanel3danhsachtaikhoanLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton1insert)
                .addGap(29, 29, 29)
                .addComponent(jButton2delete)
                .addGap(42, 42, 42)
                .addComponent(jButton1update)
                .addGap(42, 42, 42)
                .addComponent(jButton1clearn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3danhsachtaikhoanLayout.setVerticalGroup(
            jPanel3danhsachtaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3danhsachtaikhoanLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3danhsachtaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3danhsachtaikhoanLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3danhsachtaikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1insert)
                            .addComponent(jButton2delete)
                            .addComponent(jButton1clearn)
                            .addComponent(jButton1update)))
                    .addGroup(jPanel3danhsachtaikhoanLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tai Khoan", jPanel3danhsachtaikhoan);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "thong tin hanh khach ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(153, 0, 204))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Ten Hanh Khach");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("So dien thoai");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Giay chung minh");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Ma Tau khach");

        jTextField2tenhanhkhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2tenhanhkhachActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Ma Hanh khach");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel35))
                .addGap(81, 81, 81)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1mahk, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addComponent(jTextField2tenhanhkhach)
                        .addComponent(jTextField3sodienthoai)
                        .addComponent(jTextField4giaychungminh))
                    .addComponent(jComboBox1mataukhach, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1mahk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jTextField2tenhanhkhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField3sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel28))
                    .addComponent(jTextField4giaychungminh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jComboBox1mataukhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jButton1inserthk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_add.png"))); // NOI18N
        jButton1inserthk.setText("insert");
        jButton1inserthk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1inserthkActionPerformed(evt);
            }
        });

        jButton2updatehk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_save.png"))); // NOI18N
        jButton2updatehk.setText("update");

        jButton3deletehk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton3deletehk.setText("delete");

        jButton1clearnhk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton1clearnhk.setText("clearn");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "thong tin ngay xuat ben", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(51, 102, 0))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Ma nam");

        jComboBox1manam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MN_15", "MN_16", "MN_17", "MN_18", "MN_19", "MN_20", "MN_21", "MN_22", "MN_23", "MN_24", "MN_25" }));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Ngay xuat ben");

        jTextArea1mota.setColumns(20);
        jTextArea1mota.setRows(5);
        jScrollPane6.setViewportView(jTextArea1mota);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Mo Ta");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Ma Tau khach");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Ma hanh khach");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCalendarCombo1ngaysb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1manam, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox3mahanhkhach, 0, 127, Short.MAX_VALUE)
                                    .addComponent(jComboBox2mataukhach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jComboBox1manam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jCalendarCombo1ngaysb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel32))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jComboBox2mataukhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox3mahanhkhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jButton1insertngayxb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_add.png"))); // NOI18N
        jButton1insertngayxb.setText("Insert");

        jTable2danhsachhanhkhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTable2danhsachhanhkhach);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("Danh Sach Hanh Khach");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setText("Danh sach ngay xuat ben");

        jTable1danhsachxuatben.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTable1danhsachxuatben);

        jButton1deletengayxb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlytaukhach/images/btn_delete.png"))); // NOI18N
        jButton1deletengayxb.setText("Delete");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1inserthk, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton2updatehk, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3deletehk, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1clearnhk, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel36))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton1insertngayxb, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton1deletengayxb, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1inserthk)
                                    .addComponent(jButton2updatehk)
                                    .addComponent(jButton3deletehk)
                                    .addComponent(jButton1clearnhk)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel36)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1insertngayxb)
                            .addComponent(jButton1deletengayxb))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong tin hanh khach", jPanel3);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1themActionPerformed
        try {
            if (!this.hinhanh.isEmpty()) {
                tk.setHinhanh(converfile(hinhanh));
            } else {
                tk.setHinhanh(null);
            }

            tk.setMatk(this.jTextField1matk.getText());
            tk.setTentk(this.jTextField2tentk.getText());
            tk.setThientruong(this.jTextField3thientruong.getText());
            tk.setTuyenduong(this.jTextField4tuyenduong.getText());
            tk.setTocdo(this.jTextField5tocdo.getText());
            tk.setGiave(Double.parseDouble(this.jTextField6giave.getText()));
            tk.setMact(this.jTextField7mact.getText());

            if (tk.getMatk().equals("") || tk.getTentk().equals("") || tk.getThientruong().equals("") || tk.getTuyenduong().equals("") || tk.getTocdo().equals("") || String.valueOf(tk.getGiave()).equals("") || tk.getMact().equals("") || tk.getHinhanh().equals("")) {
                JOptionPane.showMessageDialog(null, "khong duoc bo rong");
            } else {
                if (kiemtratrung(this.jTextField1matk.getText())) {
                    if (tkd.create(tk)) {
                        JOptionPane.showMessageDialog(null, "tao thanh cong");
                        findtk(tkd.findll());

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ma bi trung");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jButton1themActionPerformed

    private void jButton1bromseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1bromseActionPerformed
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.setDialogTitle("chon file hinh");
            jfc.setMultiSelectionEnabled(false);
            jfc.setFileFilter(new Myter("PNG", "png"));
            jfc.setFileFilter(new Myter("JPG", "jpg"));
            jfc.setFileFilter(new Myter("TXT", "txt"));
            jfc.setFileFilter(new Myter("GIF", "gif"));
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                this.hinhanh = jfc.getSelectedFile().getAbsolutePath();
                BufferedImage images = ImageIO.read(new File(hinhanh));
                int x = this.jLabel10hinhanh.getSize().width;
                int y = this.jLabel10hinhanh.getSize().height;
                int ix = images.getWidth();
                int iy = images.getHeight();
                int dx = 0;
                int dy = 0;
                if (x / y > ix / iy) {
                    dy = y;
                    dx = dy * ix / iy;
                } else {
                    dx = x;
                    dy = dx * iy / ix;
                }
                ImageIcon icon = new ImageIcon(images.getScaledInstance(349, 114, images.getHeight()));
                this.jLabel10hinhanh.setIcon(icon);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jButton1bromseActionPerformed

    private void jButton1themctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1themctActionPerformed
        ctvt.setMact(this.jTextField2macongty.getText());
        ctvt.setTenct(this.jTextField3tenct.getText());
        ctvt.setSdt(this.jTextField4sdt.getText());
        ctvt.setDiachi(this.jTextField5diachi.getText());
        ctvt.setGiamdocdh(this.jTextField6giamdocdieuhanh.getText());
        if (ctvt.getMact().equals("") || ctvt.getTenct().equals("") || ctvt.getSdt().equals("") || ctvt.getDiachi().equals("") || ctvt.getGiamdocdh().equals("")) {
            JOptionPane.showMessageDialog(null, "khong duoc bo rong");
        } else {
            if (kiemtratrungct(this.jTextField2macongty.getText())) {

                if (ctvtdao.create(ctvt)) {
                    JOptionPane.showMessageDialog(null, "tao thanh cong");
                    findct(ctvtdao.findll());
                }
            } else {
                JOptionPane.showMessageDialog(null, "trung ma cong ty");
            }
        }
    }//GEN-LAST:event_jButton1themctActionPerformed

    private void jButton3clearnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3clearnActionPerformed
        this.jTextField1matk.setText("");
        this.jTextField2tentk.setText("");
        this.jTextField3thientruong.setText("");
        this.jTextField5tocdo.setText("");
        this.jTextField6giave.setText("");
        this.jLabel10hinhanh.setIcon(new ImageIcon(""));
        this.jTextField4tuyenduong.setText("");
        this.jTextField7mact.setText("");
    }//GEN-LAST:event_jButton3clearnActionPerformed

    private void jTable1taukhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1taukhachMouseClicked

        try {
            int index = this.jTable1taukhach.getSelectedRow();
            String matk = this.jTable1taukhach.getValueAt(index, 0).toString();
            taukhach tk = tkd.find(matk);
            this.jTextField1matk.setText(tk.getMatk());
            this.jTextField2tentk.setText(tk.getTentk());
            this.jTextField3thientruong.setText(tk.getThientruong());
            this.jTextField4tuyenduong.setText(tk.getTuyenduong());
            this.jTextField5tocdo.setText(tk.getTocdo());
            this.jTextField6giave.setText(String.valueOf(tk.getGiave()));

            this.jTextField7mact.setText(tk.getMact());

            this.jLabel10hinhanh.setIcon(new ImageIcon(tk.getHinhanh()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jTable1taukhachMouseClicked

    private void jButton3clearnctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3clearnctActionPerformed
        this.jTextField2macongty.setText("");
        this.jTextField3tenct.setText("");
        this.jTextField4sdt.setText("");
        this.jTextField5diachi.setText("");
        this.jTextField6giamdocdieuhanh.setText("");
    }//GEN-LAST:event_jButton3clearnctActionPerformed

    private void jTable1congtyvantaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1congtyvantaiMouseClicked
        int index = this.jTable1congtyvantai.getSelectedRow();
        String mact = this.jTable1congtyvantai.getValueAt(index, 0).toString();
        congtyvantai ctvt = ctvtdao.findlimit(mact);
        this.jTextField2macongty.setText(ctvt.getMact());
        this.jTextField3tenct.setText(ctvt.getTenct());
        this.jTextField4sdt.setText(ctvt.getSdt());
        this.jTextField5diachi.setText(ctvt.getDiachi());
        this.jTextField6giamdocdieuhanh.setText(ctvt.getGiamdocdh());
    }//GEN-LAST:event_jTable1congtyvantaiMouseClicked

    private void jButton2capnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2capnhapActionPerformed
        try {
            if (!this.hinhanh.isEmpty()) {
                tk.setHinhanh(converfile(hinhanh));
            } else {
                tk.setHinhanh(null);
            }

            tk.setMatk(this.jTextField1matk.getText());
            tk.setTentk(this.jTextField2tentk.getText());
            tk.setThientruong(this.jTextField3thientruong.getText());
            tk.setTuyenduong(this.jTextField4tuyenduong.getText());
            tk.setTocdo(this.jTextField5tocdo.getText());
            tk.setGiave(Double.parseDouble(this.jTextField6giave.getText()));
            tk.setMact(this.jTextField7mact.getText());

            if (tk.getMatk().equals("") || tk.getTentk().equals("") || tk.getThientruong().equals("") || tk.getTuyenduong().equals("") || tk.getTocdo().equals("") || String.valueOf(tk.getGiave()).equals("") || tk.getMact().equals("") || tk.getHinhanh().equals("")) {
                JOptionPane.showMessageDialog(null, "khong duoc bo rong");
            } else {

                if (tkd.update(tk)) {
                    JOptionPane.showMessageDialog(null, "cap nhap thanh cong");
                    findtk(tkd.findll());

                } else {
                    JOptionPane.showMessageDialog(null, "cap nhap that bai");
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jButton2capnhapActionPerformed

    private void jButton1deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1deleteActionPerformed
        try {

            int result = JOptionPane.showConfirmDialog(null, "are you sure", "delete tau khach", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                int index = this.jTable1taukhach.getSelectedRow();
                String matk = this.jTable1taukhach.getValueAt(index, 0).toString();

                taukhach tk = new taukhach();
                tk.setMatk(matk);

                if (tkd.delete(tk)) {
                    JOptionPane.showMessageDialog(null, "xoa thanh cong");
                    findtk(tkd.findll());

                } else {
                    JOptionPane.showMessageDialog(null, "xoa khong thanh cong");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1deleteActionPerformed

    private void jButton1searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1searchActionPerformed
        search();
    }//GEN-LAST:event_jButton1searchActionPerformed

    private void jTextField1searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1searchKeyPressed
        search();
    }//GEN-LAST:event_jTextField1searchKeyPressed

    private void jTextField3hotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3hotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3hotenActionPerformed

    private void jButton1insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1insertActionPerformed
        Taikhoan tk = new Taikhoan();
        tk.setUsername(this.jTextField1username.getText());
        tk.setPassword(this.jTextField2password.getText());
        tk.setHoten(this.jTextField3hoten.getText());
        tk.setEmail(this.jTextField4email.getText());
        int index = this.jComboBox1mauquyen.getSelectedIndex();
        tk.setMaquyen(this.dsquyen.get(index).getMaquyen());

        if (tk.getUsername().equals("") || tk.getPassword().equals("") || tk.getHoten().equals("") || tk.getEmail().equals("")) {

            JOptionPane.showMessageDialog(null, "ban khong duoc bo  rong");
        } else {
            if (kiemtrausername(this.jTextField1username.getText())) {
                if (taikhoandao.create(tk)) {
                    JOptionPane.showMessageDialog(null, "tao thanh cong");
                    findtaikhoan(taikhoandao.findll());
                } else {
                    JOptionPane.showMessageDialog(null, "tao khong thanh cong");
                }

            } else {
                JOptionPane.showMessageDialog(null, "trung ma username");
            }
        }

    }//GEN-LAST:event_jButton1insertActionPerformed

    private void jButton1clearnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1clearnActionPerformed
        this.jTextField1username.setText("");
        this.jTextField2password.setText("");
        this.jTextField3hoten.setText("");
        this.jTextField4email.setText("");
    }//GEN-LAST:event_jButton1clearnActionPerformed

    private void jTable1danhsachtaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1danhsachtaikhoanMouseClicked
        int index = this.jTable1danhsachtaikhoan.getSelectedRow();
        String unsername = this.jTable1danhsachtaikhoan.getValueAt(index, 0).toString();
        Taikhoan taik = taikhoandao.find(unsername);
        this.jTextField1username.setText(taik.getUsername());
        this.jTextField2password.setText(taik.getPassword());
        this.jTextField3hoten.setText(taik.getHoten());
        this.jTextField4email.setText(taik.getEmail());
        maquyendao mad = new maquyendao();
        maquyen ma = mqd.find(taik.getMaquyen());
        this.jComboBox1mauquyen.setSelectedItem(ma.getTenquyen());

    }//GEN-LAST:event_jTable1danhsachtaikhoanMouseClicked

    private void jButton2deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2deleteActionPerformed
        try {

            int result = JOptionPane.showConfirmDialog(null, "are you sure", "delete tai khoan", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                int index = this.jTable1danhsachtaikhoan.getSelectedRow();
                String username = this.jTable1danhsachtaikhoan.getValueAt(index, 0).toString();

                Taikhoan taik = new Taikhoan();
                taik.setUsername(username);
                if (taikhoandao.delete(taik)) {
                    JOptionPane.showMessageDialog(null, "xoa thanh cong");
                    findtaikhoan(taikhoandao.findll());

                } else {
                    JOptionPane.showMessageDialog(null, "xoa khong thanh cong");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton2deleteActionPerformed

    private void jButton1updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1updateActionPerformed
        Taikhoan taik = new Taikhoan();
        taik.setUsername(this.jTextField1username.getText());
        taik.setPassword(this.jTextField2password.getText());
        taik.setHoten(this.jTextField3hoten.getText());
        taik.setEmail(this.jTextField4email.getText());
        int index = this.jComboBox1mauquyen.getSelectedIndex();
        taik.setMaquyen(this.dsquyen.get(index).getMaquyen());

        if (taik.getUsername().equals("") || taik.getPassword().equals("") || taik.getHoten().equals("") || taik.getEmail().equals("")) {
            JOptionPane.showMessageDialog(null, "ban khong duoc bo rong");
        } else {
            if (kiemtrataikhoan(this.jTextField1username.getText())) {
                if (taikhoandao.update(taik)) {
                    JOptionPane.showMessageDialog(null, "cap nhap thanh cong");
                    findtaikhoan(taikhoandao.findll());
                } else {
                    JOptionPane.showMessageDialog(null, "cap nhap that bai");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ban phai chon username de cap nhap");
            }
        }

    }//GEN-LAST:event_jButton1updateActionPerformed

    private void jButton1capnhapctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1capnhapctActionPerformed
        ctvt.setMact(this.jTextField2macongty.getText());
        ctvt.setTenct(this.jTextField3tenct.getText());
        ctvt.setSdt(this.jTextField4sdt.getText());
        ctvt.setDiachi(this.jTextField5diachi.getText());
        ctvt.setGiamdocdh(this.jTextField6giamdocdieuhanh.getText());
        if (ctvt.getMact().equals("") || ctvt.getTenct().equals("") || ctvt.getSdt().equals("") || ctvt.getDiachi().equals("") || ctvt.getGiamdocdh().equals("")) {
            JOptionPane.showMessageDialog(null, "khong duoc bo rong");
        } else {
            if (capnhapct(this.jTextField2macongty.getText())) {
                if (ctvtdao.update(ctvt)) {
                    JOptionPane.showMessageDialog(null, "cap nhap thanh cong");
                    findct(ctvtdao.findll());
                }
            } else {
                JOptionPane.showMessageDialog(null, "ban phai nhap ma cong ty de cap nhap");
            }
        }
    }//GEN-LAST:event_jButton1capnhapctActionPerformed

    private void jButton2deletectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2deletectActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "are you sure", "delete cong ty", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            int index = this.jTable1congtyvantai.getSelectedRow();
            String mact = this.jTable1congtyvantai.getValueAt(index, 0).toString();
            congtyvantai ctvt = new congtyvantai();
            ctvt.setMact(mact);
            if (ctvtdao.delete(ctvt)) {
                JOptionPane.showMessageDialog(null, "xoa thanh cong");
                findct(ctvtdao.findll());
            } else {
                JOptionPane.showMessageDialog(null, "xoa khong thanh cong");
            }
        }

    }//GEN-LAST:event_jButton2deletectActionPerformed

    private void jButton1saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1saveActionPerformed

        try {
            JFileChooser jfc = new JFileChooser();
            jfc.setMultiSelectionEnabled(false);
            jfc.setDialogTitle("luu file");
            jfc.setFileFilter(new Myter("TXT", "txt"));
            jfc.setFileFilter(new Myter("PNG", "png"));
            jfc.setFileFilter(new Myter("JPG", "jpg"));
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                String content = this.jTextArea1content.getText();
                FileOutputStream fos = new FileOutputStream(jfc.getSelectedFile());
                fos.write(content.getBytes());
                fos.flush();
                fos.close();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }//GEN-LAST:event_jButton1saveActionPerformed

    private void jButton2openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2openActionPerformed
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.setMultiSelectionEnabled(false);
            jfc.setDialogTitle("mo file");
            jfc.setFileFilter(new Myter("TXT", "txt"));
            jfc.setFileFilter(new Myter("PNG", "png"));
            jfc.setFileFilter(new Myter("JPG", "jpg"));
            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                FileInputStream fis = new FileInputStream(jfc.getSelectedFile());
                int ch;
                String s = "";
                while ((ch = fis.read()) != -1) {
                    s += String.valueOf((char) ch);
                }
                this.jTextArea1content.setText(s);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2openActionPerformed

    private void jTextField2tenhanhkhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2tenhanhkhachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2tenhanhkhachActionPerformed

    private void jButton1inserthkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1inserthkActionPerformed


    }//GEN-LAST:event_jButton1inserthkActionPerformed

    private void jComboBox1mauquyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1mauquyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1mauquyenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              dispose();
              login l = new login();
              l.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void search() {
        /*   DefaultTableModel dtm = (DefaultTableModel) this.jTable1taukhach.getModel();
         dtm.fireTableDataChanged();
         TableRowSorter sorter = new TableRowSorter(dtm);
         this.jTable1taukhach.setRowSorter(sorter);
         sorter.setRowFilter(RowFilter.regexFilter(this.jTextField1search.getText()));*/

        DefaultTableModel dtm = (DefaultTableModel) this.jTable1taukhach.getModel();
        dtm.fireTableDataChanged();
        TableRowSorter sorter = new TableRowSorter(dtm);
        this.jTable1taukhach.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(this.jTextField1search.getText()));
    }

    private byte[] converfile(String filename) {
        FileInputStream fis = null;
        File f = new File(filename);
        byte[] bfile = new byte[(int) f.length()];
        try {
            fis = new FileInputStream(f);
            fis.read(bfile);
            fis.close();
        } catch (Exception e) {
            return bfile = null;
        }
        return bfile;
    }

    private boolean kiemtratrung(String matk) {
        for (taukhach tk : tkd.findll()) {
            if (tk.getMatk().equalsIgnoreCase(matk)) {
                return false;
            }
        }
        return true;
    }

    private boolean kiemtracapnhap(String matk) {
        for (taukhach tk : tkd.findll()) {
            if (tk.getMatk().equalsIgnoreCase(matk)) {
                return true;
            }
        }
        return false;
    }

    private boolean kiemtrataikhoan(String username) {
        for (Taikhoan taik : taikhoandao.findll()) {
            if (taik.getUsername().equalsIgnoreCase(username)) {
                return true;

            }
        }

        return false;
    }

    private boolean kiemtratrungct(String mact) {
        for (congtyvantai ctvt : ctvtdao.findll()) {
            if (ctvt.getMact().equalsIgnoreCase(mact)) {
                return false;
            }
        }
        return true;
    }

    private boolean kiemtrausername(String username) {
        for (Taikhoan tk : taikhoandao.findll()) {
            if (tk.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }

        return true;
    }

    private boolean capnhapct(String mact) {
        for (congtyvantai ctvt : ctvtdao.findll()) {
            if (ctvt.getMact().equalsIgnoreCase(mact)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramequanlytaukhach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramequanlytaukhach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramequanlytaukhach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramequanlytaukhach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramequanlytaukhach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1bromse;
    private javax.swing.JButton jButton1capnhapct;
    private javax.swing.JButton jButton1clearn;
    private javax.swing.JButton jButton1clearnhk;
    private javax.swing.JButton jButton1delete;
    private javax.swing.JButton jButton1deletengayxb;
    private javax.swing.JButton jButton1insert;
    private javax.swing.JButton jButton1inserthk;
    private javax.swing.JButton jButton1insertngayxb;
    private javax.swing.JButton jButton1save;
    private javax.swing.JButton jButton1search;
    private javax.swing.JButton jButton1them;
    private javax.swing.JButton jButton1themct;
    private javax.swing.JButton jButton1update;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2capnhap;
    private javax.swing.JButton jButton2delete;
    private javax.swing.JButton jButton2deletect;
    private javax.swing.JButton jButton2open;
    private javax.swing.JButton jButton2updatehk;
    private javax.swing.JButton jButton3clearn;
    private javax.swing.JButton jButton3clearnct;
    private javax.swing.JButton jButton3deletehk;
    private org.freixas.jcalendar.JCalendarCombo jCalendarCombo1ngaysb;
    private javax.swing.JComboBox jComboBox1manam;
    private javax.swing.JComboBox jComboBox1mataukhach;
    private javax.swing.JComboBox jComboBox1mauquyen;
    private javax.swing.JComboBox jComboBox2mataukhach;
    private javax.swing.JComboBox jComboBox3mahanhkhach;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel10hinhanh;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel2date;
    private javax.swing.JLabel jLabel2time;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel3danhsachtaikhoan;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel4danhsachcongty;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1congtyvantai;
    private javax.swing.JTable jTable1danhsachtaikhoan;
    private javax.swing.JTable jTable1danhsachxuatben;
    private javax.swing.JTable jTable1taukhach;
    private javax.swing.JTable jTable2danhsachhanhkhach;
    private javax.swing.JTextArea jTextArea1content;
    private javax.swing.JTextArea jTextArea1mota;
    private javax.swing.JTextField jTextField1mahk;
    private javax.swing.JTextField jTextField1matk;
    private javax.swing.JTextField jTextField1search;
    private javax.swing.JTextField jTextField1username;
    private javax.swing.JTextField jTextField2macongty;
    private javax.swing.JTextField jTextField2password;
    private javax.swing.JTextField jTextField2tenhanhkhach;
    private javax.swing.JTextField jTextField2tentk;
    private javax.swing.JTextField jTextField3hoten;
    private javax.swing.JTextField jTextField3sodienthoai;
    private javax.swing.JTextField jTextField3tenct;
    private javax.swing.JTextField jTextField3thientruong;
    private javax.swing.JTextField jTextField4email;
    private javax.swing.JTextField jTextField4giaychungminh;
    private javax.swing.JTextField jTextField4sdt;
    private javax.swing.JTextField jTextField4tuyenduong;
    private javax.swing.JTextField jTextField5diachi;
    private javax.swing.JTextField jTextField5tocdo;
    private javax.swing.JTextField jTextField6giamdocdieuhanh;
    private javax.swing.JTextField jTextField6giave;
    private javax.swing.JTextField jTextField7mact;
    // End of variables declaration//GEN-END:variables
}
