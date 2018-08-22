package burp;


import java.io.PrintWriter;
import java.util.*;

public class Utilities {
	
    public static byte[] addIPHead(IExtensionHelpers helpers, IHttpRequestResponse requestResponse,String key) {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("X-Forwarded-For","X-Forwarded-For: 127.0.0.1");
    	map.put("X-remote-IP","X-remote-IP: 127.0.0.1");
    	map.put("X-Originating-IP","X-Originating-IP: 127.0.0.1");
    	map.put("X-remote-addr","X-remote-addr: 127.0.0.1");
    	map.put("True-Client-IP","True-Client-IP: 127.0.0.1");
    	map.put("Client-IP","Client-IP: 127.0.0.1");
    	map.put("X-Client-IP","X-Client-IP: 127.0.0.1");
    	map.put("X-Real-IP","X-Real-IP: 127.0.0.1");
   
    	byte[] request = requestResponse.getRequest();
        IRequestInfo requestInfo = helpers.analyzeRequest(request);
        int bodyOffset = requestInfo.getBodyOffset();
        String body = new String(request, bodyOffset, request.length - bodyOffset);
        
        Boolean isExists = false;
        List<String> headers;
        headers = helpers.analyzeRequest(request).getHeaders();
        
        for(int i = 0;i<headers.size();i++){
        	if(headers.get(i).startsWith(key)){
        		headers.set(i, map.get(key)); 
        		isExists = true;
        	}
        }
        if(!isExists){
        	headers.add(map.get(key));
        }
        
        return helpers.buildHttpMessage(headers, body.getBytes());
    }
    

    
    public static byte[] modifyUserAgent(IExtensionHelpers helpers, IHttpRequestResponse requestResponse,String uaid) {
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("Nexus7", "Mozilla/5.0 (Linux; Android 4.1.1; Nexus 7 Build/JRO03D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166  Safari/535.19");
    	map.put("AndroidGalaxyS3", "Mozilla/5.0 (Linux; U; Android 4.0.4; en-gb; GT-I9300 Build/IMM76D) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
        map.put("AndroidGalaxyTab", "Mozilla/5.0 (Linux; U; Android 2.2; en-gb; GT-P1000 Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        map.put("FFAndroidHandset", "Mozilla/5.0 (Android; Mobile; rv:14.0) Gecko/14.0 Firefox/14.0");
        map.put("FFAndroidTablet", "Mozilla/5.0 (Android; Tablet; rv:14.0) Gecko/14.0 Firefox/14.0");
        map.put("FFMac", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:21.0) Gecko/20100101 Firefox/21.0");
        map.put("FFUbuntu", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:21.0) Gecko/20130331 Firefox/21.0");
        map.put("FFWin", "Mozilla/5.0 (Windows NT 6.2; WOW64; rv:21.0) Gecko/20100101 Firefox/21.0");
        map.put("ChromeAndroidMobile", "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
        map.put("ChromeAndroidTablet", "Mozilla/5.0 (Linux; Android 4.1.2; Nexus 7 Build/JZ054K) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Safari/535.19");
        map.put("ChromeMac", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36");
        map.put("ChromeUbuntu", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.11 (KHTML, like Gecko) Ubuntu/11.10 Chromium/27.0.1453.93 Chrome/27.0.1453.93 Safari/537.36");
        map.put("ChromeWin", "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.94 Safari/537.36");
        map.put("ChromeiPhone", "Mozilla/5.0 (iPhone; CPU iPhone OS 6_1_4 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) CriOS/27.0.1453.10 Mobile/10B350 Safari/8536.25");
        map.put("IE11", "Mozilla/5.0 (Windows NT 6.3; Trident/7.0; rv 11.0) like Gecko");
        map.put("IE10", "Mozilla/5.0 (compatible; WOW64; MSIE 10.0; Windows NT 6.2)");
        map.put("IE6", "Mozilla/4.0 (Windows; MSIE 6.0; Windows NT 5.2)");
        map.put("IE7", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)");
        map.put("IE8", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)");
        map.put("IE9", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
        map.put("Edge12", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.246");
        map.put("Edge13", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586");
        map.put("OperaMac", "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.9.168 Version/11.52");
        map.put("OperaWin", "Opera/9.80 (Windows NT 6.1; WOW64; U; en) Presto/2.10.229 Version/11.62");
        map.put("SafariMac", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_6; en-US) AppleWebKit/533.20.25 (KHTML, like Gecko) Version/5.0.4 Safari/533.20.27");
        map.put("SafariWin", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/533.20.25 (KHTML, like Gecko) Version/5.0.4 Safari/533.20.27");
        map.put("SafariiPad", "Mozilla/5.0 (iPad; CPU OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");
        map.put("SafariiPhone", "Mozilla/5.0 (iPhone; CPU iPhone OS 5_0 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9A334 Safari/7534.48.3");
        map.put("BingBot", "Mozilla/5.0 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)");
        map.put("Googlebot", "Googlebot/2.1 (+http://www.googlebot.com/bot.html)");
        map.put("Slurp", "Mozilla/5.0 (compatible; Yahoo! Slurp; http://help.yahoo.com/help/us/ysearch/slurp)");
        map.put("Baidu_pc", "Mozilla/5.0 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)");
        map.put("Baidu_app", "Mozilla/5.0 (Linux;u;Android 4.2.2;zh-cn;) AppleWebKit/534.46 (KHTML,like Gecko) Version/5.1 Mobile Safari/10600.6.3 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)");
    	map.put("Win7Phone","Mozilla/4.0 (compatible; MSIE 7.0; Windows Phone OS 7.0; Trident/3.1; IEMobile/7.0; LG; GW910)");
    	map.put("Win75Phone","Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; SAMSUNG; SGH-i917)");
    	map.put("Win8Phone", "Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0; Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920)");
    	map.put("iPad","Mozilla/5.0 (iPad; CPU OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12B466 Safari/600.1.4");
    	map.put("iPhone","Mozilla/5.0 (iPhone; CPU iPhone OS 8_0_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12A366 Safari/600.1.4");
    	map.put("iPod", "Mozilla/5.0 (iPod; CPU iPhone OS 5_1_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Version/5.1 Mobile/9B206 Safari/7534.48.3");
    	byte[] request = requestResponse.getRequest();
        IRequestInfo requestInfo = helpers.analyzeRequest(request);
        int bodyOffset = requestInfo.getBodyOffset();
        String body = new String(request, bodyOffset, request.length - bodyOffset);

        Boolean isExists = false;
        List<String> headers;
        headers = helpers.analyzeRequest(request).getHeaders();
        
        for(int i = 0;i<headers.size();i++){
        	if(headers.get(i).startsWith("User-Agent")){
        		String strUA = String.format("User-Agent: %s", map.get(uaid));
        		headers.set(i, strUA); 
        		isExists = true;
        	}
        }
        if(!isExists){
        	headers.add(String.format("User-Agent: %s", map.get(uaid)));
        }
        
        return helpers.buildHttpMessage(headers, body.getBytes());
    }
    
    public static byte[] addOrigin(IExtensionHelpers helpers, IHttpRequestResponse requestResponse) {
        IHttpService httpService = requestResponse.getHttpService();
        String url;
        if(httpService.getProtocol().equals("https")){
        	url = String.format("%s://%s",httpService.getProtocol(),httpService.getHost(),httpService.getPort());
        }else{
        	url = String.format("%s://%s:%s",httpService.getProtocol(),httpService.getHost(),httpService.getPort());
        }
        
    	byte[] request = requestResponse.getRequest();
        IRequestInfo requestInfo = helpers.analyzeRequest(request);
        int bodyOffset = requestInfo.getBodyOffset();
        String body = new String(request, bodyOffset, request.length - bodyOffset);

        Boolean isExists = false;
        List<String> headers;
        headers = helpers.analyzeRequest(request).getHeaders();
                
        for(int i = 0;i<headers.size();i++){
        	if(headers.get(i).startsWith("Origin:")){
        		String strOrigin = String.format("Origin: %s",url);
        		headers.set(i, strOrigin); 
        		isExists = true;
        	}
        }
        if(!isExists){
        	headers.add(String.format("Origin: %s",url));
        }
        
        return helpers.buildHttpMessage(headers, body.getBytes());
    }
    
    public static byte[] updateCookie(IBurpExtenderCallbacks callbacks,IExtensionHelpers helpers, IHttpRequestResponse requestResponse) {
    	byte[] request = requestResponse.getRequest();
    	PrintWriter stdout = new PrintWriter(callbacks.getStdout(),true);
    	String shorturl = requestResponse.getHttpService().toString();
    	stdout.println("[+] "+shorturl);
		String latestCookie = getLatestCookieFromHistory(callbacks,helpers,shorturl);
		stdout.println("[+] "+latestCookie);
		IRequestInfo requestInfo = helpers.analyzeRequest(request);
        int bodyOffset = requestInfo.getBodyOffset();
        String body = new String(request, bodyOffset, request.length - bodyOffset);
        
        Boolean isExists = false;
        List<String> headers;
        headers = helpers.analyzeRequest(request).getHeaders();
        
        for(int i = 0;i<headers.size();i++){
        	if(headers.get(i).toLowerCase().startsWith("cookie:")){
        		headers.set(i, latestCookie); 
        		isExists = true;
        	}
        }
        if(!isExists){
        	headers.add(latestCookie);
        }
        
        return helpers.buildHttpMessage(headers, body.getBytes());
    }
    
    public static IHttpRequestResponse[] Reverse(IHttpRequestResponse[] input){
	    for (int start = 0, end = input.length - 1; start < end; start++, end--) {
	    	IHttpRequestResponse temp = input[end];
	        input[end] = input[start];
	        input[start] = temp;
	    }
	    return input;
	}
    
    public static String getLatestCookieFromHistory(IBurpExtenderCallbacks callbacks,IExtensionHelpers helpers,String shortUrl){

    	IHttpRequestResponse[]  historyMessages = Reverse(callbacks.getProxyHistory());
    	String lastestCookie =null;
    	for (IHttpRequestResponse historyMessage:historyMessages) {
    		IRequestInfo hisAnalyzedRequest = helpers.analyzeRequest(historyMessage);
    		String hisShortUrl = historyMessage.getHttpService().toString();
    		
    		if (hisShortUrl.equals(shortUrl)) {
    			List<String> hisHeaders = hisAnalyzedRequest.getHeaders();
    			for (String hisHeader:hisHeaders) {
    				if (hisHeader.toLowerCase().startsWith("cookie:")) {
    					lastestCookie = hisHeader;
            			if(lastestCookie != null) {
            				return lastestCookie;
            			}
    				}
    			}
    		}
    	}
		return null;
	}
}