package getarry;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame
{
	private JFrame frame = new JFrame("");
	private Container container = this.frame.getContentPane();
	private JCheckBox jcb1 = new JCheckBox("a+b=c：", false);
	private JTextField text1 = new JTextField("4,2,0");
	private JTextField text2 = new JTextField("1,2,8,11,14,21");
	private JTextField text3 = new JTextField("1,2,6,8,15,23");
	private JTextField text4 = new JTextField("5,7,9,23,24,28");
	private JTextField text5 = new JTextField("1,3,5,16,17,21,29,0,0,0");
	private JTextField text6 = new JTextField("18,19,25,27,32,0,0,0,0,0");
	private JTextField text7 = new JTextField("17,26,0,0,0,0,0,0");
	private JTextField text8 = new JTextField("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,20,21,22,23,24,28,31,33,5");
	private JTextField text9 = new JTextField("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,17,26,5");
	private JTextField text10 = new JTextField("3,5,7,9,17,23,24,28");
	private JTextField text11 = new JTextField("0,0,0");
	private JTextField text12 = new JTextField("0,0,0");
	private JCheckBox jcb2 = new JCheckBox("是否存在连续数", false);
	private int[] zone_num;
	private int[] input_num3;
	private int[] input_num4;
	private int[] input_num5;
	private int[] input_num6;
	private int[] input_num7;
	private int[] input_num8;
	private int[] input_num9;
	private int[] input_num10;
	private int[] input_num11;
	private int[] input_num12;
	private int[] input_num13;
	private JButton button = new JButton("提交");
	private JPanel panel = new JPanel();
	private JLabel label1 = new JLabel("条件1");
	private JLabel label2 = new JLabel("条件2，输入分区挑选数字的个数，以英文“,”分隔，以回车结束");
	private JLabel label3 = new JLabel("条件3,most 2");
	private JLabel label4 = new JLabel("条件4,most 2");
	private JLabel label5 = new JLabel("条件5,most 2");
	private JLabel label6 = new JLabel("条件6,most 2");
	private JLabel label7 = new JLabel("条件7,most 1");
	private JLabel label8 = new JLabel("条件8,most 2");
	private JLabel label9 = new JLabel("条件9,输入G1、G2、…Gn、G，所选数组有G个在G1~Gn中");
	private JLabel label10 = new JLabel("条件10,输入H1、H2、…Hn、H，所选数组有H个在H1~Hn中");
	private JLabel label11 = new JLabel("条件11,输入数L1、L2、L3……Ln，所选数组有2~4个与L1~Ln相同");
	private JLabel label12 = new JLabel("条件12,输入M1、M2、…Mn、M，所选数组有M个在M1~Mn中");
	private JLabel label13 = new JLabel("条件13,输入N1、N2、…Nn、N，所选数组有N个在N1~Nn中");
	private JLabel label14 = new JLabel("条件14,是否存在连续数");

	private static boolean flag_abc = false;
	private static boolean flag_ctn = false;

	public void MyCheckBox() {
		this.panel.setBorder(BorderFactory.createTitledBorder("请选择条件"));
		this.panel.setLayout(new GridLayout(40, 2));

		this.panel.add(this.label1); this.panel.add(this.jcb1);
		this.panel.add(this.label2); this.panel.add(this.text1);
		this.panel.add(this.label3); this.panel.add(this.text2);
		this.panel.add(this.label4); this.panel.add(this.text3);
		this.panel.add(this.label5); this.panel.add(this.text4);
		this.panel.add(this.label6); this.panel.add(this.text5);
		this.panel.add(this.label7); this.panel.add(this.text6);
		this.panel.add(this.label8); this.panel.add(this.text7);
		this.panel.add(this.label9); this.panel.add(this.text8);
		this.panel.add(this.label10); this.panel.add(this.text9);
		this.panel.add(this.label11); this.panel.add(this.text10);
		this.panel.add(this.label12); this.panel.add(this.text11);
		this.panel.add(this.label13); this.panel.add(this.text12);
		this.panel.add(this.label14); this.panel.add(this.jcb2);

		this.panel.add(this.button);
		event1 e1 = new event1();
		event2 e2 = new event2();
		this.button.addActionListener(e1);
		this.text1.addActionListener(e2);
		this.text2.addActionListener(e2);
		this.text3.addActionListener(e2);
		this.text4.addActionListener(e2);
		this.text5.addActionListener(e2);
		this.text6.addActionListener(e2);
		this.text7.addActionListener(e2);
		this.text8.addActionListener(e2);
		this.text9.addActionListener(e2);
		this.text10.addActionListener(e2);
		this.text11.addActionListener(e2);
		this.text12.addActionListener(e2);

		this.jcb1.addItemListener(new abcItemListener());
		this.jcb2.addItemListener(new ctnItemListener());
		this.container.add(this.panel);
		this.frame.setSize(600, 700);
		this.frame.setVisible(true);
		this.frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent arg0) {
				System.exit(1);
			}
		});
	}

	public static void main(String[] args)
			throws Exception
			{
		Frame f = new Frame();
		f.MyCheckBox();
			}

	public int[] convertStrToArray(String str)
	{
		String[] strArray = str.split(",", -1);
		int[] list = new int[strArray.length];

		for (int i = 0; i < strArray.length; i++) {
			list[i] = Integer.parseInt(strArray[i]);
		}
		return list;
	}

	public static void filewrite(List<int[]> newlist) throws Exception
	{
		FileWriter fw = new FileWriter("d:\\ary.txt");
		for (int i = 0; i < newlist.size(); i++) {
			int[] temp = (int[])newlist.get(i);
			for (int j = 0; j < temp.length; j++) {
				fw.write(temp[j] + " ");
			}
			fw.write("\r\n");
		}
		fw.close();
	}

	public List<int[]> isabc(List<int[]> list) throws Exception
	{
		List<int[]> newlist = new ArrayList();
		List<int[]> newlist2 = new ArrayList();
		List<int[]> resultlist = new ArrayList();
		int cnt = 0;
		int[] temp;
		for (int i = 0; i < list.size(); i++) {
			temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++)
			{
				for (int k = 0; (k < temp.length) && (k != j); k++)
				{
					for (int l = 0; (l < temp.length) && (l != j) && (l != k); l++) {
						if (temp[j] != temp[k] + temp[l])
							continue;
						cnt++;
					}
				}
			}

			if (cnt >= 1)
				newlist.add(temp);
			else {
				newlist2.add(temp);
			}
			cnt = 0;
		}
		if (flag_abc) {
			for (int[] getlist : newlist)
				resultlist.add((int[])getlist.clone());
		}
		if (!flag_abc) {
			for (int[] getlist : newlist2)
				resultlist.add((int[])getlist.clone());
		}
		return resultlist;
	}

	public List<int[]> zonenum(List<int[]> list, int[] zone)
	{
		List newlist = new ArrayList();
		int cout1 = 0; int cout2 = 0; int cout3 = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++) {
				if ((Math.abs(temp[j]) >= 1) && (Math.abs(temp[j]) <= 11))
				{
					cout1++;
				}
				else if ((Math.abs(temp[j]) >= 12) && (Math.abs(temp[j]) <= 22))
					cout2++;
				else
					cout3++;
			}
			if ((zone[0] == cout1) && (zone[1] == cout2) && (zone[2] == cout3))
			{
				newlist.add(temp);
			}
			cout1 = 0; cout2 = 0; cout3 = 0;
		}
		return newlist;
	}

	public List<int[]> samenum_most(List<int[]> list, int[] inputArry, int samenum) {
		List newlist = new ArrayList();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++) {
				for (int k = 0; k < inputArry.length; k++) {
					if (temp[j] == inputArry[k]) {
						count++;
					}
				}
			}
			if (count <= samenum)
				newlist.add(temp);
			count = 0;
		}
		return newlist;
	}

	public List<int[]> samenum_least(List<int[]> list, int[] inputArry, int samenum) {
		List newlist = new ArrayList();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++) {
				for (int k = 0; k < inputArry.length; k++) {
					if (temp[j] == inputArry[k]) {
						count++;
					}
				}
			}
			if (count >= samenum)
				newlist.add(temp);
			count = 0;
		}
		return newlist;
	}

	public List<int[]> primenum(List<int[]> list, int primenum) {
		List newlist = new ArrayList();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++) {
				if (Combination.isPrime(temp[j])) {
					count++;
				}
			}
			if (count == primenum)
				newlist.add(temp);
			count = 0;
		}
		return newlist;
	}
	public List<int[]> oddnum(List<int[]> list, int oddnum) {
		List newlist = new ArrayList();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++) {
				if (Math.abs(temp[j]) % 2 != 0) {
					count++;
				}
			}
			if (count == oddnum)
				newlist.add(temp);
			count = 0;
		}
		return newlist;
	}
	public List<int[]> samenum(List<int[]> list, int[] inputArry, int samenum) {
		List newlist = new ArrayList();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++) {
				for (int k = 0; k < inputArry.length - 1; k++) {
					if (temp[j] == inputArry[k]) {
						count++;
					}
				}
			}
			if (count == samenum)
				newlist.add(temp);
			count = 0;
		}
		return newlist;
	}

	public List<int[]> samenumRange(List<int[]> list, int[] inputArry)
	{
		List newlist = new ArrayList();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int element : temp) {
				for (int element2 : inputArry) {
					if (element == element2) {
						count++;
					}
				}
			}
			if ((count >= 2) && (count <= 4))
				newlist.add(temp);
			count = 0;
		}
		return newlist;
	}

	public List<int[]> littlenum(List<int[]> list, int littlenum)
	{
		List newlist = new ArrayList();
		int cout1 = 0; int cout2 = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] temp = (int[])list.get(i);
			for (int j = 0; j < temp.length; j++) {
				if ((Math.abs(temp[j]) < 1) || (Math.abs(temp[j]) > 16))
					continue;
				cout1++;
			}

			if (cout1 == littlenum)
			{
				newlist.add(temp);
			}
			cout1 = 0;
		}
		return newlist;
	}

	public List<int[]> ctnnum(List<int[]> list)
	{
		List<int[]> newlist = new ArrayList();
		List<int[]> newlist2 = new ArrayList();
		List<int[]> resultlist = new ArrayList();
		int count = 0;
		int[] temp;
		for (int i = 0; i < list.size(); i++) {
			temp = (int[])list.get(i);
			for (int j = 0; j < temp.length - 1; j++) {
				if (temp[(j + 1)] - temp[j] == 1) {
					count++;
				}
			}
			if (count >= 1)
				newlist.add(temp);
			else {
				newlist2.add(temp);
			}
			count = 0;
		}
		if (flag_ctn) {
			for (int[] getlist : newlist)
				resultlist.add((int[])getlist.clone());
		}
		if (!flag_ctn) {
			for (int[] getlist : newlist2)
				resultlist.add((int[])getlist.clone());
		}
		return resultlist;
	}

	public static void filewrite2(List<int[]> newlist) throws Exception
	{
		FileWriter fw = new FileWriter("d:\\aryfisrt.txt");
		for (int i = 0; i < newlist.size(); i++) {
			int[] temp = (int[])newlist.get(i);
			for (int j = 0; j < temp.length; j++) {
				fw.write(temp[j] + " ");
			}
			fw.write("\r\n");
		}
		fw.close();
	}

	class abcItemListener
	implements ItemListener
	{
		abcItemListener()
		{
		}

		public void itemStateChanged(ItemEvent e)
		{
			JCheckBox jcb = (JCheckBox)e.getItem();
			if (jcb.isSelected())
				Frame.flag_abc = true;
			else
				Frame.flag_abc = false; 
		}
	}

	class ctnItemListener implements ItemListener {
		ctnItemListener() {
		}

		public void itemStateChanged(ItemEvent e) {
			JCheckBox jcb = (JCheckBox)e.getItem();
			if (jcb.isSelected())
				Frame.flag_ctn = true;
			else
				Frame.flag_ctn = false;
		}
	}

	class event1
	implements ActionListener
	{
		public List<int[]> newlist1 = new ArrayList();
		public List<int[]> newlist2 = new ArrayList();
		public List<int[]> newlist3 = new ArrayList();
		public List<int[]> newlist4 = new ArrayList();
		public List<int[]> newlist5 = new ArrayList();
		public List<int[]> newlist6 = new ArrayList();
		public List<int[]> newlist7 = new ArrayList();
		public List<int[]> newlist8 = new ArrayList();
		public List<int[]> newlist9 = new ArrayList();
		public List<int[]> newlist10 = new ArrayList();
		public List<int[]> newlist11 = new ArrayList();
		public List<int[]> newlist12 = new ArrayList();
		public List<int[]> newlist13 = new ArrayList();
		public List<int[]> newlist14 = new ArrayList();
		public List<int[]> newlist15 = new ArrayList();

		event1() {
		}
		public void actionPerformed(ActionEvent e) { try { List newlist = new ArrayList();
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33 };
		int m = 6;
		Combination c = new Combination();
		Frame f = new Frame();
		List list = c.combination(a, m);
		newlist = c.screen(list);
//		filewrite2(newlist);
		newlist = isabc(newlist);
		newlist = ctnnum(newlist);

		if ((zone_num == null) || (input_num3 == null) || 
				(input_num4 == null) || (input_num5 == null) || 
				(input_num6 == null) || (input_num7 == null) || 
				(input_num8 == null) || (input_num9 == null) || 
				(input_num10 == null) || (input_num11 == null) || 
				(input_num12 == null) || (input_num13 == null))
		{
			JOptionPane.showMessageDialog(null, "输入有空值！", "警告", 0);
		}
		else {
			this.newlist2 = zonenum(newlist, zone_num);

			this.newlist3 = samenum_most(this.newlist2, input_num3, 2);
			this.newlist4 = samenum_most(this.newlist3, input_num4, 2);
			this.newlist5 = samenum_most(this.newlist4, input_num5, 2);
			this.newlist6 = samenum_most(this.newlist5, input_num6, 2);
			this.newlist7 = samenum_most(this.newlist6, input_num7, 1);
			this.newlist8 = samenum_most(this.newlist7, input_num8, 2);

			this.newlist9 = samenum(this.newlist8, input_num9, input_num9[(input_num9.length - 1)]);
	
			this.newlist10 = samenum(this.newlist9, input_num10, input_num10[(input_num10.length - 1)]);

			this.newlist11 = samenumRange(this.newlist10, input_num11);

			this.newlist12 = samenum(this.newlist11, input_num12,input_num12[(input_num12.length - 1)]);
			this.newlist13 = samenum(this.newlist12, input_num13,input_num13[(input_num13.length - 1)]);
			Frame.filewrite(this.newlist13);
			JOptionPane.showMessageDialog(null, "一共" + this.newlist13.size() + "组!");
		}
		newlist.clear();
		} catch (Exception e1)
		{
			e1.printStackTrace();
		} }
	}

	class event2 implements ActionListener {
		event2() {
		}

		public void actionPerformed(ActionEvent e) {
			try {
				zone_num = convertStrToArray(text1.getText());
				input_num3 = convertStrToArray(text2.getText());
				input_num4 = convertStrToArray(text3.getText());
				input_num5 = convertStrToArray(text4.getText());
				input_num6 = convertStrToArray(text5.getText());
				input_num7 = convertStrToArray(text6.getText());
				input_num8 = convertStrToArray(text7.getText());
				input_num9 = convertStrToArray(text8.getText());
				input_num10 = convertStrToArray(text9.getText());
				input_num11 = convertStrToArray(text10.getText());
				input_num12 = convertStrToArray(text11.getText());
				input_num13 = convertStrToArray(text12.getText());
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
	}
}