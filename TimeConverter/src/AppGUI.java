import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;


public class AppGUI {

	private JFrame frame;
	private JTextField TimeFrom;
	private JTextField DateFrom;
	private JTextField FinalConverted;
	
	private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppGUI window = new AppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppGUI() {
		initialize();
	}
	
			

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(107, 217, 213));
		frame.getContentPane().setFont(new Font("Arial", Font.ITALIC, 13));
		frame.setBounds(100, 100, 599, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TimeFrom = new JTextField();
		TimeFrom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char charRead = e.getKeyChar();
				if ( !Character.isDigit(charRead) && charRead != ':' || charRead == KeyEvent.VK_BACK_SPACE || TimeFrom.getText().length() >= 8) {
					e.consume();
				}
			}
		});
		TimeFrom.setBounds(36, 275, 147, 26);
		frame.getContentPane().add(TimeFrom);
		TimeFrom.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" From ");
		lblNewLabel.setForeground(new Color(20, 48, 201));
		lblNewLabel.setBounds(82, 161, 71, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setForeground(new Color(26, 48, 193));
		lblNewLabel_2.setBounds(415, 161, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		String[] timeZones = {"--SELECT TIME ZONE--" , "Africa/Abidjan" , "Africa/Accra" , "Africa/Addis_Ababa" , "Africa/Algiers" , "Africa/Asmara" , "Africa/Asmera" , "Africa/Bamako" , "Africa/Bangui" , "Africa/Banjul" , "Africa/Bissau" , "Africa/Blantyre" , "Africa/Brazzaville" , "Africa/Bujumbura" , "Africa/Cairo" , "Africa/Casablanca" , "Africa/Ceuta" , "Africa/Conakry" , "Africa/Dakar" , "Africa/Dar_es_Salaam" , "Africa/Djibouti" , "Africa/Douala" , "Africa/El_Aaiun" , "Africa/Freetown" , "Africa/Gaborone" , "Africa/Harare" , "Africa/Johannesburg" , "Africa/Juba" , "Africa/Kampala" , "Africa/Khartoum" , "Africa/Kigali" , "Africa/Kinshasa" , "Africa/Lagos" , "Africa/Libreville" , "Africa/Lome" , "Africa/Luanda" , "Africa/Lubumbashi" , "Africa/Lusaka" , "Africa/Malabo" , "Africa/Maputo" , "Africa/Maseru" , "Africa/Mbabane" , "Africa/Mogadishu" , "Africa/Monrovia" , "Africa/Nairobi" , "Africa/Ndjamena" , "Africa/Niamey" , "Africa/Nouakchott" , "Africa/Ouagadougou" , "Africa/Porto-Novo" , "Africa/Sao_Tome" , "Africa/Timbuktu" , "Africa/Tripoli" , "Africa/Tunis" , "Africa/Windhoek" , "America/Adak" , "America/Anchorage" , "America/Anguilla" , "America/Antigua" , "America/Araguaina" , "America/Argentina/Buenos_Aires" , "America/Argentina/Catamarca" , "America/Argentina/ComodRivadavia" , "America/Argentina/Cordoba" , "America/Argentina/Jujuy" , "America/Argentina/La_Rioja" , "America/Argentina/Mendoza" , "America/Argentina/Rio_Gallegos" , "America/Argentina/Salta" , "America/Argentina/San_Juan" , "America/Argentina/San_Luis" , "America/Argentina/Tucuman" , "America/Argentina/Ushuaia" , "America/Aruba" , "America/Asuncion" , "America/Atikokan" , "America/Atka" , "America/Bahia" , "America/Bahia_Banderas" , "America/Barbados" , "America/Belem" , "America/Belize" , "America/Blanc-Sablon" , "America/Boa_Vista" , "America/Bogota" , "America/Boise" , "America/Buenos_Aires" , "America/Cambridge_Bay" , "America/Campo_Grande" , "America/Cancun" , "America/Caracas" , "America/Catamarca" , "America/Cayenne" , "America/Cayman" , "America/Chicago" , "America/Chihuahua" , "America/Coral_Harbour" , "America/Cordoba" , "America/Costa_Rica" , "America/Creston" , "America/Cuiaba" , "America/Curacao" , "America/Danmarkshavn" , "America/Dawson" , "America/Dawson_Creek" , "America/Denver" , "America/Detroit" , "America/Dominica" , "America/Edmonton" , "America/Eirunepe" , "America/El_Salvador" , "America/Ensenada" , "America/Fort_Nelson" , "America/Fort_Wayne" , "America/Fortaleza" , "America/Glace_Bay" , "America/Godthab" , "America/Goose_Bay" , "America/Grand_Turk" , "America/Grenada" , "America/Guadeloupe" , "America/Guatemala" , "America/Guayaquil" , "America/Guyana" , "America/Halifax" , "America/Havana" , "America/Hermosillo" , "America/Indiana/Indianapolis" , "America/Indiana/Knox" , "America/Indiana/Marengo" , "America/Indiana/Petersburg" , "America/Indiana/Tell_City" , "America/Indiana/Vevay" , "America/Indiana/Vincennes" , "America/Indiana/Winamac" , "America/Indianapolis" , "America/Inuvik" , "America/Iqaluit" , "America/Jamaica" , "America/Jujuy" , "America/Juneau" , "America/Kentucky/Louisville" , "America/Kentucky/Monticello" , "America/Knox_IN" , "America/Kralendijk" , "America/La_Paz" , "America/Lima" , "America/Los_Angeles" , "America/Louisville" , "America/Lower_Princes" , "America/Maceio" , "America/Managua" , "America/Manaus" , "America/Marigot" , "America/Martinique" , "America/Matamoros" , "America/Mazatlan" , "America/Mendoza" , "America/Menominee" , "America/Merida" , "America/Metlakatla" , "America/Mexico_City" , "America/Miquelon" , "America/Moncton" , "America/Monterrey" , "America/Montevideo" , "America/Montreal" , "America/Montserrat" , "America/Nassau" , "America/New_York" , "America/Nipigon" , "America/Nome" , "America/Noronha" , "America/North_Dakota/Beulah" , "America/North_Dakota/Center" , "America/North_Dakota/New_Salem" , "America/Nuuk" , "America/Ojinaga" , "America/Panama" , "America/Pangnirtung" , "America/Paramaribo" , "America/Phoenix" , "America/Port-au-Prince" , "America/Port_of_Spain" , "America/Porto_Acre" , "America/Porto_Velho" , "America/Puerto_Rico" , "America/Punta_Arenas" , "America/Rainy_River" , "America/Rankin_Inlet" , "America/Recife" , "America/Regina" , "America/Resolute" , "America/Rio_Branco" , "America/Rosario" , "America/Santa_Isabel" , "America/Santarem" , "America/Santiago" , "America/Santo_Domingo" , "America/Sao_Paulo" , "America/Scoresbysund" , "America/Shiprock" , "America/Sitka" , "America/St_Barthelemy" , "America/St_Johns" , "America/St_Kitts" , "America/St_Lucia" , "America/St_Thomas" , "America/St_Vincent" , "America/Swift_Current" , "America/Tegucigalpa" , "America/Thule" , "America/Thunder_Bay" , "America/Tijuana" , "America/Toronto" , "America/Tortola" , "America/Vancouver" , "America/Virgin" , "America/Whitehorse" , "America/Winnipeg" , "America/Yakutat" , "America/Yellowknife" , "Antarctica/Casey" , "Antarctica/Davis" , "Antarctica/DumontDUrville" , "Antarctica/Macquarie" , "Antarctica/Mawson" , "Antarctica/McMurdo" , "Antarctica/Palmer" , "Antarctica/Rothera" , "Antarctica/South_Pole" , "Antarctica/Syowa" , "Antarctica/Troll" , "Antarctica/Vostok" , "Arctic/Longyearbyen" , "Asia/Aden" , "Asia/Almaty" , "Asia/Amman" , "Asia/Anadyr" , "Asia/Aqtau" , "Asia/Aqtobe" , "Asia/Ashgabat" , "Asia/Ashkhabad" , "Asia/Atyrau" , "Asia/Baghdad" , "Asia/Bahrain" , "Asia/Baku" , "Asia/Bangkok" , "Asia/Barnaul" , "Asia/Beirut" , "Asia/Bishkek" , "Asia/Brunei" , "Asia/Calcutta" , "Asia/Chita" , "Asia/Choibalsan" , "Asia/Chongqing" , "Asia/Chungking" , "Asia/Colombo" , "Asia/Dacca" , "Asia/Damascus" , "Asia/Dhaka" , "Asia/Dili" , "Asia/Dubai" , "Asia/Dushanbe" , "Asia/Famagusta" , "Asia/Gaza" , "Asia/Harbin" , "Asia/Hebron" , "Asia/Ho_Chi_Minh" , "Asia/Hong_Kong" , "Asia/Hovd" , "Asia/Irkutsk" , "Asia/Istanbul" , "Asia/Jakarta" , "Asia/Jayapura" , "Asia/Jerusalem" , "Asia/Kabul" , "Asia/Kamchatka" , "Asia/Karachi" , "Asia/Kashgar" , "Asia/Kathmandu" , "Asia/Katmandu" , "Asia/Khandyga" , "Asia/Kolkata" , "Asia/Krasnoyarsk" , "Asia/Kuala_Lumpur" , "Asia/Kuching" , "Asia/Kuwait" , "Asia/Macao" , "Asia/Macau" , "Asia/Magadan" , "Asia/Makassar" , "Asia/Manila" , "Asia/Muscat" , "Asia/Nicosia" , "Asia/Novokuznetsk" , "Asia/Novosibirsk" , "Asia/Omsk" , "Asia/Oral" , "Asia/Phnom_Penh" , "Asia/Pontianak" , "Asia/Pyongyang" , "Asia/Qatar" , "Asia/Qostanay" , "Asia/Qyzylorda" , "Asia/Rangoon" , "Asia/Riyadh" , "Asia/Saigon" , "Asia/Sakhalin" , "Asia/Samarkand" , "Asia/Seoul" , "Asia/Shanghai" , "Asia/Singapore" , "Asia/Srednekolymsk" , "Asia/Taipei" , "Asia/Tashkent" , "Asia/Tbilisi" , "Asia/Tehran" , "Asia/Tel_Aviv" , "Asia/Thimbu" , "Asia/Thimphu" , "Asia/Tokyo" , "Asia/Tomsk" , "Asia/Ujung_Pandang" , "Asia/Ulaanbaatar" , "Asia/Ulan_Bator" , "Asia/Urumqi" , "Asia/Ust-Nera" , "Asia/Vientiane" , "Asia/Vladivostok" , "Asia/Yakutsk" , "Asia/Yangon" , "Asia/Yekaterinburg" , "Asia/Yerevan" , "Atlantic/Azores" , "Atlantic/Bermuda" , "Atlantic/Canary" , "Atlantic/Cape_Verde" , "Atlantic/Faeroe" , "Atlantic/Faroe" , "Atlantic/Jan_Mayen" , "Atlantic/Madeira" , "Atlantic/Reykjavik" , "Atlantic/South_Georgia" , "Atlantic/St_Helena" , "Atlantic/Stanley" , "Australia/ACT" , "Australia/Adelaide" , "Australia/Brisbane" , "Australia/Broken_Hill" , "Australia/Canberra" , "Australia/Currie" , "Australia/Darwin" , "Australia/Eucla" , "Australia/Hobart" , "Australia/LHI" , "Australia/Lindeman" , "Australia/Lord_Howe" , "Australia/Melbourne" , "Australia/NSW" , "Australia/North" , "Australia/Perth" , "Australia/Queensland" , "Australia/South" , "Australia/Sydney" , "Australia/Tasmania" , "Australia/Victoria" , "Australia/West" , "Australia/Yancowinna" , "Brazil/Acre" , "Brazil/DeNoronha" , "Brazil/East" , "Brazil/West" , "CET" , "CST6CDT" , "Canada/Atlantic" , "Canada/Central" , "Canada/Eastern" , "Canada/Mountain" , "Canada/Newfoundland" , "Canada/Pacific" , "Canada/Saskatchewan" , "Canada/Yukon" , "Chile/Continental" , "Chile/EasterIsland" , "Cuba" , "EET" , "EST5EDT" , "Egypt" , "Eire" , "Etc/GMT" , "Etc/GMT+0" , "Etc/GMT+1" , "Etc/GMT+10" , "Etc/GMT+11" , "Etc/GMT+12" , "Etc/GMT+2" , "Etc/GMT+3" , "Etc/GMT+4" , "Etc/GMT+5" , "Etc/GMT+6" , "Etc/GMT+7" , "Etc/GMT+8" , "Etc/GMT+9" , "Etc/GMT-0" , "Etc/GMT-1" , "Etc/GMT-10" , "Etc/GMT-11" , "Etc/GMT-12" , "Etc/GMT-13" , "Etc/GMT-14" , "Etc/GMT-2" , "Etc/GMT-3" , "Etc/GMT-4" , "Etc/GMT-5" , "Etc/GMT-6" , "Etc/GMT-7" , "Etc/GMT-8" , "Etc/GMT-9" , "Etc/GMT0" , "Etc/Greenwich" , "Etc/UCT" , "Etc/UTC" , "Etc/Universal" , "Etc/Zulu" , "Europe/Amsterdam" , "Europe/Andorra" , "Europe/Astrakhan" , "Europe/Athens" , "Europe/Belfast" , "Europe/Belgrade" , "Europe/Berlin" , "Europe/Bratislava" , "Europe/Brussels" , "Europe/Bucharest" , "Europe/Budapest" , "Europe/Busingen" , "Europe/Chisinau" , "Europe/Copenhagen" , "Europe/Dublin" , "Europe/Gibraltar" , "Europe/Guernsey" , "Europe/Helsinki" , "Europe/Isle_of_Man" , "Europe/Istanbul" , "Europe/Jersey" , "Europe/Kaliningrad" , "Europe/Kiev" , "Europe/Kirov" , "Europe/Lisbon" , "Europe/Ljubljana" , "Europe/London" , "Europe/Luxembourg" , "Europe/Madrid" , "Europe/Malta" , "Europe/Mariehamn" , "Europe/Minsk" , "Europe/Monaco" , "Europe/Moscow" , "Europe/Nicosia" , "Europe/Oslo" , "Europe/Paris" , "Europe/Podgorica" , "Europe/Prague" , "Europe/Riga" , "Europe/Rome" , "Europe/Samara" , "Europe/San_Marino" , "Europe/Sarajevo" , "Europe/Saratov" , "Europe/Simferopol" , "Europe/Skopje" , "Europe/Sofia" , "Europe/Stockholm" , "Europe/Tallinn" , "Europe/Tirane" , "Europe/Tiraspol" , "Europe/Ulyanovsk" , "Europe/Uzhgorod" , "Europe/Vaduz" , "Europe/Vatican" , "Europe/Vienna" , "Europe/Vilnius" , "Europe/Volgograd" , "Europe/Warsaw" , "Europe/Zagreb" , "Europe/Zaporozhye" , "Europe/Zurich" , "GB" , "GB-Eire" , "GMT" , "GMT0" , "Greenwich" , "Hongkong" , "Iceland" , "Indian/Antananarivo" , "Indian/Chagos" , "Indian/Christmas" , "Indian/Cocos" , "Indian/Comoro" , "Indian/Kerguelen" , "Indian/Mahe" , "Indian/Maldives" , "Indian/Mauritius" , "Indian/Mayotte" , "Indian/Reunion" , "Iran" , "Israel" , "Jamaica" , "Japan" , "Kwajalein" , "Libya" , "MET" , "MST7MDT" , "Mexico/BajaNorte" , "Mexico/BajaSur" , "Mexico/General" , "NZ" , "NZ-CHAT" , "Navajo" , "PRC" , "PST8PDT" , "Pacific/Apia" , "Pacific/Auckland" , "Pacific/Bougainville" , "Pacific/Chatham" , "Pacific/Chuuk" , "Pacific/Easter" , "Pacific/Efate" , "Pacific/Enderbury" , "Pacific/Fakaofo" , "Pacific/Fiji" , "Pacific/Funafuti" , "Pacific/Galapagos" , "Pacific/Gambier" , "Pacific/Guadalcanal" , "Pacific/Guam" , "Pacific/Honolulu" , "Pacific/Johnston" , "Pacific/Kanton" , "Pacific/Kiritimati" , "Pacific/Kosrae" , "Pacific/Kwajalein" , "Pacific/Majuro" , "Pacific/Marquesas" , "Pacific/Midway" , "Pacific/Nauru" , "Pacific/Niue" , "Pacific/Norfolk" , "Pacific/Noumea" , "Pacific/Pago_Pago" , "Pacific/Palau" , "Pacific/Pitcairn" , "Pacific/Pohnpei" , "Pacific/Ponape" , "Pacific/Port_Moresby" , "Pacific/Rarotonga" , "Pacific/Saipan" , "Pacific/Samoa" , "Pacific/Tahiti" , "Pacific/Tarawa" , "Pacific/Tongatapu" , "Pacific/Truk" , "Pacific/Wake" , "Pacific/Wallis" , "Pacific/Yap" , "Poland" , "Portugal" , "ROK" , "Singapore" , "SystemV/AST4" , "SystemV/AST4ADT" , "SystemV/CST6" , "SystemV/CST6CDT" , "SystemV/EST5" , "SystemV/EST5EDT" , "SystemV/HST10" , "SystemV/MST7" , "SystemV/MST7MDT" , "SystemV/PST8" , "SystemV/PST8PDT" , "SystemV/YST9" , "SystemV/YST9YDT" , "Turkey" , "UCT" , "US/Alaska" , "US/Aleutian" , "US/Arizona" , "US/Central" , "US/East-Indiana" , "US/Eastern" , "US/Hawaii" , "US/Indiana-Starke" , "US/Michigan" , "US/Mountain" , "US/Pacific" , "US/Samoa" , "UTC" , "Universal" , "W-SU" , "WET" , "Zulu" , "EST" , "HST" , "MST" , "ACT" , "AET" , "AGT" , "ART" , "AST" , "BET" , "BST" , "CAT" , "CNT" , "CST" , "CTT" , "EAT" , "ECT" , "IET" , "IST" , "JST" , "MIT" , "NET" , "NST" , "PLT" , "PNT" , "PRT" , "PST" , "SST" , "VST" , };
		
		
		String[] AMPM = { "Select", "AM" , "PM"};
		
		JComboBox TimeZoneFrom = new JComboBox(timeZones);
		TimeZoneFrom.setBounds(20, 189, 211, 27);
		frame.getContentPane().add(TimeZoneFrom);
		
		JComboBox TimeZoneTo = new JComboBox(timeZones);
		TimeZoneTo.setBounds(344, 189, 206, 27);
		frame.getContentPane().add(TimeZoneTo);
		
		JLabel lblNewLabel_3 = new JLabel("TimeZone Converter");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_3.setForeground(new Color(42, 117, 22));
		lblNewLabel_3.setBounds(189, 35, 269, 37);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Time (Hour : Min : Sec)");
		lblNewLabel_1_2.setForeground(new Color(17, 37, 182));
		lblNewLabel_1_2.setBounds(41, 247, 142, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		DateFrom = new JTextField();
		DateFrom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char charRead = e.getKeyChar();
				if ( (!Character.isDigit(charRead) && charRead != '/') || charRead == KeyEvent.VK_BACK_SPACE || DateFrom.getText().length() >= 10) {
					e.consume();
				}
			}
		});
		DateFrom.setBounds(42, 351, 130, 26);
		frame.getContentPane().add(DateFrom);
		DateFrom.setColumns(10);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Date -- (DD/MM/YYYY)");
		lblNewLabel_1_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_2_2.setForeground(new Color(17, 37, 182));
		lblNewLabel_1_2_2.setBounds(46, 323, 126, 16);
		frame.getContentPane().add(lblNewLabel_1_2_2);
		
		FinalConverted = new JTextField();
		FinalConverted.setEditable(false);
		FinalConverted.setColumns(10);
		FinalConverted.setBounds(358, 275, 192, 26);
		frame.getContentPane().add(FinalConverted);
		
		JComboBox FromAMPM = new JComboBox(AMPM);
		FromAMPM.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		FromAMPM.setBounds(183, 277, 86, 27);
		frame.getContentPane().add(FromAMPM);
		
		
		JButton Button = new JButton("Convert");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String fromTimeZone =  (String) TimeZoneFrom.getSelectedItem();
					String toTimeZone =  (String) TimeZoneTo.getSelectedItem();
					String fromAMPM = (String) FromAMPM.getSelectedItem();
					
					String fromDate = DateFrom.getText();
					String fromTime = TimeFrom.getText();
					

					
					String[] hourmin = fromTime.split(":");
					int hour = 0;
					int minutes = 0;
					hour = Integer.parseInt(hourmin[0]);
					minutes = Integer.parseInt(hourmin[1]);
					
					String[] DDMMYY = fromDate.split("/");
					int Day = 0;
					int Month = 0;
					int Year = 0;
					Day = Integer.parseInt(DDMMYY[0]);
					Month = Integer.parseInt(DDMMYY[1]);
					Year = Integer.parseInt(DDMMYY[2]);
					
					if (Day > 31 || Day == 0 ) {
						JOptionPane.showMessageDialog(frame, "Inalid Input !! [Check the Date]" );
					}
					
					if (Month > 12 || Month == 0 ) {
						JOptionPane.showMessageDialog(frame, "Inalid Input !! [Check the Date]" );
					}
					
					if (hour > 12 || (hour == 12 && minutes > 0) ) {
						JOptionPane.showMessageDialog(frame, "Inalid Input !! [Check the time]" );
					}
					
					if (minutes > 60 ) {
						JOptionPane.showMessageDialog(frame, "Inalid Input !! [Check the time]" );
					}
					
			        String dateInString = (Integer.toString(Day) + "-" + Integer.toString(Month) + "-" + Integer.toString(Year) + " " + fromTime + " " + fromAMPM);
			        
			        ZoneId fromZone = ZoneId.of(fromTimeZone);
			        ZoneId toZone = ZoneId.of(toTimeZone);
			        
			    	
			        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH));
			        	        
			        ZonedDateTime fromZoneTime = ldt.atZone(fromZone);
			        
			        ZonedDateTime convertedDateTime = fromZoneTime.withZoneSameInstant(toZone);
			        
			        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH);
			        
			        FinalConverted.setText(format.format(convertedDateTime));
			        
				}
				catch ( Exception x ) {
					JOptionPane.showMessageDialog(frame, "Inalid Input !!" );
				}
				
			}
		});
		Button.setForeground(new Color(27, 11, 140));
		Button.setBackground(new Color(34, 31, 146));
		Button.setFont(new Font("Arial", Font.BOLD, 14));
		Button.setBounds(256, 351, 117, 29);
		frame.getContentPane().add(Button);
		
		JLabel lblNewLabel_1 = new JLabel("Converted Time");
		lblNewLabel_1.setForeground(new Color(16, 32, 255));
		lblNewLabel_1.setBounds(386, 238, 152, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton DarkMode = new JRadioButton("Dark Mode");
		
		DarkMode.setBounds(422, 372, 141, 37);
		DarkMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DarkMode.isSelected()) {
				frame.getContentPane().setBackground(new Color(0, 0, 0));
				lblNewLabel_3.setForeground(new Color(255, 255, 255));
				DarkMode.setForeground(new Color(255, 255, 255));
			}
			else {
				frame.getContentPane().setBackground(new Color(107, 217, 213));
				lblNewLabel_3.setForeground(new Color(42, 117, 22));
				DarkMode.setForeground(new Color(0, 0, 0));
			}
			}
		});
		frame.getContentPane().add(DarkMode);
		
	}
}
