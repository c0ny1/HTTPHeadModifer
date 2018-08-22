package burp;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Menu implements IContextMenuFactory {
    private IBurpExtenderCallbacks callbacks;
    private final IExtensionHelpers m_helpers;
    private PrintWriter stdout;
    private PrintWriter stderr;
    private JMenu httpHeadModiferMenu;
    //IPÏà¹ØÍ·
    private JMenuItem addXFF;
    private JMenuItem addXRI;
    private JMenuItem addXOI;
    private JMenuItem addXRA;
    private JMenuItem addTrueClientIP;
    private JMenuItem addClientIP;
    private JMenuItem addXClientIP;
    private JMenuItem addXRealIP;
    //ÇÐ»»UA
    private JMenu firefoxUA;
    private JMenuItem ffAndroidMobileUA;
    private JMenuItem ffAndroidTableUA;
    private JMenuItem ffMacUA;
    private JMenuItem ffUbuntuUA;
    private JMenuItem ffWinUA;
    private JMenu chromeUA;
    private JMenuItem chromeAndroidMobileUA;
    private JMenuItem chromeAndroidTableUA;
    private JMenuItem chromeMacUA;
    private JMenuItem chromeUbuntuUA;
    private JMenuItem chromeWinUA;
    private JMenuItem chromeiPhoneUA;
    
    private JMenu edgeUA;
    private JMenuItem edge12UA;
    private JMenuItem edge13UA;
    
    private JMenu ieUA;
    private JMenuItem ie11UA;
    private JMenuItem ie10UA;
    private JMenuItem ie9UA;
    private JMenuItem ie8UA;
    private JMenuItem ie7UA;
    private JMenuItem ie6UA;
    
    private JMenu operaUA;
    private JMenuItem operaMacUA;
    private JMenuItem operaWinUA;    
    
    
    private JMenu safariUA;
    private JMenuItem safariMacUA;
    private JMenuItem safariWinUA;
    private JMenuItem safariiPadUA;
    private JMenuItem safariiPhoneUA;    
    
    private JMenu androidUA;
    private JMenuItem androidNexus7UA;
    private JMenuItem androidGalaxyS3UA;
    private JMenuItem androidGalaxyTabUA;
    private JMenu winPhoneUA;
    private JMenuItem win7PhoneUA;
    private JMenuItem win75PhoneUA;
    private JMenuItem win8PhoneUA;
    
    private JMenu iosUA;
    private JMenuItem iosiPadUA;
    private JMenuItem iosiPhoneUA;
    private JMenuItem iosiPodUA;
    
    private JMenu spiderUA;
    private JMenuItem baiduSpider4pcUA;
    private JMenuItem baiduSpider4appUA;
    private JMenuItem googleSpiderUA;
    private JMenuItem bingSpiderUA;
    private JMenuItem slurpSpiderUA;
    
    private JMenuItem addOrigin;
    
    private JMenuItem updateCookie;
    
    public Menu(IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        m_helpers = callbacks.getHelpers();
        this.stdout = new PrintWriter(callbacks.getStdout(),true);
        this.stderr = new PrintWriter(callbacks.getStderr(),true);
    }

    public List<JMenuItem> createMenuItems(final IContextMenuInvocation invocation) {
        List<JMenuItem> menus = new ArrayList();

        if (invocation.getToolFlag() != IBurpExtenderCallbacks.TOOL_INTRUDER && invocation.getInvocationContext() != IContextMenuInvocation.CONTEXT_MESSAGE_EDITOR_REQUEST){
            return menus;
        }
        
        httpHeadModiferMenu = new JMenu("HTTPHeadModifer");
        addXFF = new JMenuItem("add X-Forwarded-For");
        addXRI = new JMenuItem("add X-remote-IP");
        addXOI = new JMenuItem("add X-Originating-IP");
        addXRA = new JMenuItem("add X-remote-addr");
        addTrueClientIP = new JMenuItem("add True-Client-IP");
        addClientIP = new JMenuItem("add Client-IP");
        addXClientIP = new JMenuItem("add X-Client-IP");
        addXRealIP = new JMenuItem("add X-Real-IP");
        //fifoxä¯ÀÀÆ÷UserAgent
        firefoxUA = new JMenu("Firefox UserAgent");
        ffAndroidMobileUA = new JMenuItem("Firefox on Android Mobile");
        ffAndroidTableUA = new JMenuItem("Firefox on Android Tablet");
        ffMacUA = new JMenuItem("Firefox on Mac");
        ffUbuntuUA = new JMenuItem("Firefox on Ubuntu");
        ffWinUA = new JMenuItem("Firefox on Windows");
        
        chromeUA = new JMenu("Chorme UserAgent");
        chromeAndroidMobileUA = new JMenuItem("Chrome on Android Mobile");
        chromeAndroidTableUA = new JMenuItem("Chrome on Android Tablet");
        chromeMacUA = new JMenuItem("Chrome on Mac");
        chromeUbuntuUA = new JMenuItem("Chrome on Ubuntu");
        chromeWinUA = new JMenuItem("Chrome on Windows");
        chromeiPhoneUA = new JMenuItem("Chrome on iPhone");
        
        edgeUA = new JMenu("Edge UserAgent");
        edge12UA = new JMenuItem("Edge 12");
        edge13UA = new JMenuItem("Edge13");
        
        ieUA = new JMenu("IE UserAgent");
        ie11UA = new JMenuItem("Internet Explorer 11");
        ie10UA = new JMenuItem("Internet Explorer 10");
        ie9UA = new JMenuItem("Internet Explorer 9");
        ie8UA = new JMenuItem("Internet Explorer 8");
        ie7UA = new JMenuItem("Internet Explorer 7");
        ie6UA = new JMenuItem("Internet Explorer 6");
        
        operaUA = new JMenu("Opera UserAgent");
        operaMacUA = new JMenuItem("Opera on Mac");
        operaWinUA = new JMenuItem("Opera on Windows");
        
        safariUA = new JMenu("Safari UserAgent");
        safariMacUA = new JMenuItem("Safari on Mac");
        safariWinUA = new JMenuItem("Safari on Windows");
        safariiPadUA = new JMenuItem("Safari on iPad");
        safariiPhoneUA = new JMenuItem("Safari on iPhone");

        androidUA = new JMenu("Android UserAgent");
        androidNexus7UA = new JMenuItem("Nexus 7 (Tablet)");
        androidGalaxyS3UA = new JMenuItem("Samsung Galaxy S3 (Handset)");
        androidGalaxyTabUA = new JMenuItem("Samsung Galaxy Tab (Tablet)");        
        
        winPhoneUA = new JMenu("Windows phone UserAgent");
        win7PhoneUA = new JMenuItem("Windows Phone 7");
        win75PhoneUA = new JMenuItem("Windows Phone 7.5");
        win8PhoneUA = new JMenuItem("Windows Phone 8");
        
        iosUA = new JMenu("IOS UserAgent");
        iosiPadUA = new JMenuItem("iPad");
        iosiPhoneUA = new JMenuItem("iPhone");
        iosiPodUA = new JMenuItem("iPod");
        
        spiderUA = new JMenu("Spider UserAgent");
        baiduSpider4pcUA = new JMenuItem("Badu Spider PC");
        baiduSpider4appUA = new JMenuItem("Badu Spider App");
        googleSpiderUA = new JMenuItem("Googlebot (Google's spider)");
        bingSpiderUA = new JMenuItem("BingBot (Bing's spider)");
        slurpSpiderUA = new JMenuItem("Slurp! (Yahoo's spider)");
        
        addOrigin = new JMenuItem("add Origin");
        updateCookie = new JMenuItem("Update Cookie");
        firefoxUA.add(ffAndroidMobileUA);
        firefoxUA.add(ffAndroidTableUA);
        firefoxUA.add(ffMacUA);
        firefoxUA.add(ffUbuntuUA);
        firefoxUA.add(ffWinUA);
        
        chromeUA.add(chromeAndroidMobileUA);
        chromeUA.add(chromeAndroidTableUA);
        chromeUA.add(chromeMacUA);
        chromeUA.add(chromeUbuntuUA);
        chromeUA.add(chromeWinUA);
        chromeUA.add(chromeiPhoneUA);
        
        edgeUA.add(edge12UA);
        edgeUA.add(edge13UA);
        
        ieUA.add(ie11UA);
        ieUA.add(ie10UA);
        ieUA.add(ie9UA);
        ieUA.add(ie8UA);
        ieUA.add(ie7UA);
        ieUA.add(ie6UA);
        
        operaUA.add(operaMacUA);
        operaUA.add(operaWinUA);
        
        safariUA.add(safariMacUA);
        safariUA.add(safariWinUA);
        safariUA.add(safariiPadUA);
        safariUA.add(safariiPhoneUA);
        
        androidUA.add(androidNexus7UA);
        androidUA.add(androidGalaxyS3UA);
        androidUA.add(androidGalaxyTabUA);
        
        winPhoneUA.add(win7PhoneUA);
        winPhoneUA.add(win75PhoneUA);
        winPhoneUA.add(win8PhoneUA);
        
        iosUA.add(iosiPadUA);
        iosUA.add(iosiPhoneUA);
        iosUA.add(iosiPodUA);
        
        spiderUA.add(baiduSpider4pcUA);
        spiderUA.add(baiduSpider4appUA);
        spiderUA.add(googleSpiderUA);
        spiderUA.add(bingSpiderUA);
        spiderUA.add(slurpSpiderUA);
        
        httpHeadModiferMenu.add(addXFF);
        httpHeadModiferMenu.add(addXRI);
        httpHeadModiferMenu.add(addXOI);
        httpHeadModiferMenu.add(addXRA);
        httpHeadModiferMenu.add(addTrueClientIP);
        httpHeadModiferMenu.add(addClientIP);
        httpHeadModiferMenu.add(addXClientIP);
        httpHeadModiferMenu.add(addXRealIP);
        httpHeadModiferMenu.addSeparator();
        httpHeadModiferMenu.add(firefoxUA);
        httpHeadModiferMenu.add(chromeUA);
        httpHeadModiferMenu.add(edgeUA);
        httpHeadModiferMenu.add(ieUA);
        httpHeadModiferMenu.add(operaUA);
        httpHeadModiferMenu.add(safariUA);
        httpHeadModiferMenu.add(androidUA);
        httpHeadModiferMenu.add(winPhoneUA);
        httpHeadModiferMenu.add(iosUA);
        httpHeadModiferMenu.add(spiderUA);
        httpHeadModiferMenu.addSeparator();
        httpHeadModiferMenu.add(addOrigin);
        httpHeadModiferMenu.addSeparator();
        httpHeadModiferMenu.add(updateCookie);
        
        addXFF.addActionListener(new MenuActionManger(invocation));
        addXRI.addActionListener(new MenuActionManger(invocation));
        addXOI.addActionListener(new MenuActionManger(invocation));
        addXRA.addActionListener(new MenuActionManger(invocation));
        addTrueClientIP.addActionListener(new MenuActionManger(invocation));
        addClientIP.addActionListener(new MenuActionManger(invocation));
        addXClientIP.addActionListener(new MenuActionManger(invocation));
        addXRealIP.addActionListener(new MenuActionManger(invocation));
        
        ffAndroidMobileUA.addActionListener(new MenuActionManger(invocation));
        ffAndroidTableUA.addActionListener(new MenuActionManger(invocation));
        ffMacUA.addActionListener(new MenuActionManger(invocation));
        ffUbuntuUA.addActionListener(new MenuActionManger(invocation));
        ffWinUA.addActionListener(new MenuActionManger(invocation));
        
        chromeAndroidMobileUA.addActionListener(new MenuActionManger(invocation));
        chromeAndroidTableUA.addActionListener(new MenuActionManger(invocation));
        chromeMacUA.addActionListener(new MenuActionManger(invocation));
        chromeUbuntuUA.addActionListener(new MenuActionManger(invocation));
        chromeWinUA.addActionListener(new MenuActionManger(invocation));
        chromeiPhoneUA.addActionListener(new MenuActionManger(invocation));
        
        edge12UA.addActionListener(new MenuActionManger(invocation));
        edge13UA.addActionListener(new MenuActionManger(invocation));
        
        ie11UA.addActionListener(new MenuActionManger(invocation));
        ie10UA.addActionListener(new MenuActionManger(invocation));
        ie9UA.addActionListener(new MenuActionManger(invocation));
        ie8UA.addActionListener(new MenuActionManger(invocation));
        ie7UA.addActionListener(new MenuActionManger(invocation));
        ie6UA.addActionListener(new MenuActionManger(invocation));
        
        operaMacUA.addActionListener(new MenuActionManger(invocation));
        operaWinUA.addActionListener(new MenuActionManger(invocation));
        
        safariiPadUA.addActionListener(new MenuActionManger(invocation));
        safariiPhoneUA.addActionListener(new MenuActionManger(invocation));
        safariMacUA.addActionListener(new MenuActionManger(invocation));
        safariWinUA.addActionListener(new MenuActionManger(invocation));
        
        androidNexus7UA.addActionListener(new MenuActionManger(invocation));
        androidGalaxyS3UA.addActionListener(new MenuActionManger(invocation));
        androidGalaxyTabUA.addActionListener(new MenuActionManger(invocation));
        win7PhoneUA.addActionListener(new MenuActionManger(invocation));
        win75PhoneUA.addActionListener(new MenuActionManger(invocation));
        win8PhoneUA.addActionListener(new MenuActionManger(invocation));
        
        iosiPadUA.addActionListener(new MenuActionManger(invocation));
        iosiPhoneUA.addActionListener(new MenuActionManger(invocation));
        iosiPodUA.addActionListener(new MenuActionManger(invocation));
        
        baiduSpider4pcUA.addActionListener(new MenuActionManger(invocation));
        baiduSpider4appUA.addActionListener(new MenuActionManger(invocation));
        googleSpiderUA.addActionListener(new MenuActionManger(invocation));
        bingSpiderUA.addActionListener(new MenuActionManger(invocation));
        slurpSpiderUA.addActionListener(new MenuActionManger(invocation));
        
        addOrigin.addActionListener(new MenuActionManger(invocation));
        updateCookie.addActionListener(new MenuActionManger(invocation));
        menus.add(httpHeadModiferMenu);
        return menus;
    }
    
    
    public class MenuActionManger implements ActionListener{
    	private IContextMenuInvocation invocation;
    	
    	public MenuActionManger(final IContextMenuInvocation invocation) {
			this.invocation = invocation;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			IHttpRequestResponse iReqResp = invocation.getSelectedMessages()[0];
			byte[] request = null;
            try {
				if(e.getSource() == addXFF){
					request = Utilities.addIPHead(m_helpers, iReqResp,"X-Forwarded-For");
				}
				
				if(e.getSource() == addXRI){
					request = Utilities.addIPHead(m_helpers, iReqResp,"X-remote-IP");
				}
				
				if(e.getSource() == addXOI){
					request = Utilities.addIPHead(m_helpers, iReqResp,"X-Originating-IP");
				}
				
				if(e.getSource() == addXRA){
					request = Utilities.addIPHead(m_helpers, iReqResp,"X-remote-addr");
				}
				
				if(e.getSource() == addTrueClientIP){
					request = Utilities.addIPHead(m_helpers, iReqResp,"True-Client-IP");
				}
				
				if(e.getSource() == addClientIP){
					request = Utilities.addIPHead(m_helpers, iReqResp,"Client-IP");
				}
				
				if(e.getSource() == addXClientIP){
					request = Utilities.addIPHead(m_helpers, iReqResp,"X-Client-IP");
				}
				
				if(e.getSource() == addXRealIP){
					request = Utilities.addIPHead(m_helpers, iReqResp,"X-Real-IP");
				}
				
				if(e.getSource() == ffAndroidMobileUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "FFAndroidHandset");
				}
				
				if(e.getSource() == ffAndroidTableUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "FFAndroidTablet");
				}
				
				if(e.getSource() == ffMacUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "FFMac");
				}

				if(e.getSource() == ffUbuntuUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "FFUbuntu");
				}

				if(e.getSource() == ffWinUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "FFWin");
				}
				
				if(e.getSource() == chromeAndroidMobileUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "ChromeAndroidMobile");
				}
				
				if(e.getSource() == chromeAndroidTableUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "ChromeAndroidTablet");
				}
				
				if(e.getSource() == chromeMacUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "ChromeMac");
				}
				
				if(e.getSource() == chromeUbuntuUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "ChromeUbuntu");
				}
				
				if(e.getSource() == chromeWinUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "ChromeWin");
				}
				
				if(e.getSource() == chromeiPhoneUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "ChromeiPhone");
				}
				
				if(e.getSource() == edge12UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Edge12");
				}
				
				if(e.getSource() == edge13UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Edge13");
				}		
				
				if(e.getSource() == ie11UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "IE11");
				}
				
				if(e.getSource() == ie10UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "IE10");
				}
				
				if(e.getSource() == ie9UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "IE9");
				}
				
				if(e.getSource() == ie8UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "IE8");
				}
				
				if(e.getSource() == ie7UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "IE7");
				}
				
				if(e.getSource() == ie6UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "IE6");
				}
				
				if(e.getSource() == operaMacUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "OperaMac");
				}
				
				if(e.getSource() == operaWinUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "OperaWin");
				}
				
				if(e.getSource() == safariiPadUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "SafariiPad");
				}
				
				if(e.getSource() == safariiPhoneUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "SafariiPhone");
				}
				
				if(e.getSource() == safariMacUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "SafariMac");
				}
				
				if(e.getSource() == safariWinUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "SafariWin");
				}
				
				if(e.getSource() == androidNexus7UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Nexus7");
				}
				
				if(e.getSource() == androidGalaxyS3UA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "AndroidGalaxyS3");
				}
				
				if(e.getSource() == androidGalaxyTabUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "AndroidGalaxyTab");
				}
				
				if(e.getSource() == win7PhoneUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Win7Phone");
				}
				
				if(e.getSource() == win75PhoneUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Win75Phone");
				}
				
				if(e.getSource() == win8PhoneUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Win8Phone");
				}
				
				if(e.getSource() == iosiPadUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "iPad");
				}
				
				if(e.getSource() == iosiPhoneUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "iPhone");
				}
				
				if(e.getSource() == iosiPodUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "iPod");
				}
				
				if(e.getSource() == baiduSpider4pcUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Baidu_pc");
				}
				
				if(e.getSource() == baiduSpider4appUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Baidu_app");
				}
				
				if(e.getSource() == googleSpiderUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Googlebot");
				}
				
				if(e.getSource() == bingSpiderUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "BingBot");
				}
				
				if(e.getSource() == slurpSpiderUA){
					request = Utilities.modifyUserAgent(m_helpers, iReqResp, "Slurp");
				}
				
				if(e.getSource() == addOrigin){
					request = Utilities.addOrigin(m_helpers, iReqResp);
				}
				
				if(e.getSource() == updateCookie){
					request = Utilities.updateCookie(callbacks, m_helpers, iReqResp);
				}
				
            } catch (Exception e1) {
                stderr.println(e1.getMessage());
            }
            
			if (request != null) {
                iReqResp.setRequest(request);
            }           
		}
    }
}