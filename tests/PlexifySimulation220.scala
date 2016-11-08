
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class PlexifySimulation220 extends Simulation {

	val httpProtocol = http
		.baseURL("http://plexify.com")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
		.acceptHeader("""text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8""")
		.acceptEncodingHeader("""gzip, deflate""")
		.acceptLanguageHeader("""en-US,en;q=0.5""")
		.userAgentHeader("""Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0""")

	val headers_1 = Map("""Accept""" -> """*/*""")

	val headers_2 = Map("""Accept""" -> """image/png,image/*;q=0.8,*/*;q=0.5""")

	val headers_11 = Map("""Accept""" -> """text/css,*/*;q=0.1""")

    val uri01 = """www.cbsnews.com"""
    val uri02 = """www.youtube.com"""
    val uri03 = """http://pagead2.googlesyndication.com"""
    val uri04 = """http://assets.plexify.com"""
    val uri05 = """plexify.com"""
    val uri06 = """http://www.google-analytics.com"""
    val uri07 = """www.foxnews.com"""
    val uri08 = """www.spacedaily.com"""
    val uri09 = """http://www.google.com/cse/brand"""
    val uri10 = """www.plexify.com"""
    val uri11 = """http://googleads.g.doubleclick.net/pagead"""
    val uri12 = """static.ak.facebook.com"""
    val uri13 = """fonts.googleapis.com"""
    val uri14 = """http://meg.stuzo.net/builder/static/meg/require.js"""

	val r = scala.util.Random
	val scn = scenario("PlexifySimulation")
		.exec(http("request_0")
			.get("""/""")
			.check(status.is(session => 200 + r.nextInt(2))))
		.pause(28)
		.exec(http("google_cse")
			.get(uri09 + """?form=cse-search-box&lang=en""")
			.headers(headers_1)
			.resources(http("youtube")
			.get(uri06 + """/r/__utm.gif?utmwv=5.6.0&utms=1&utmn=1537103375&utmhn=www.plexify.com&utmcs=UTF-8&utmsr=2560x1440&utmvp=818x656&utmsc=24-bit&utmul=en-us&utmje=1&utmfl=15.0%20r0&utmdt=Plexify.%20Bringing%20together%20the%20web.&utmhid=1325587837&utmr=-&utmp=%2F&utmht=1416191613192&utmac=UA-2067442-6&utmcc=__utma%3D130107598.1110978199.1415841865.1415841865.1416191613.2%3B%2B__utmz%3D130107598.1415841865.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B&utmjid=2057902077&utmredir=1&utmu=qAAAAAAAAAAAAAAAAAAAAAAE~""")
			.headers(headers_2)))
		.pause(1)
		.exec(http("request_3")
			.get(uri11 + """/html/r20141106/r20141103/zrt_lookup.html""")
			.resources(http("request_4")
			.get("http://" + uri12 + """/connect/xd_arbiter/QjK2hWv6uak.js?version=41"""),
            http("request_5")
			.get(uri11 + """/ads?client=ca-pub-6132729926491277&output=html&h=60&slotname=1975783488&adk=737065353&w=468&lmt=1416191584&flash=15.0.0&url=http%3A%2F%2Fwww.plexify.com%2F&dt=1416191614644&bpp=4&bdt=65440&shv=r20141106&cbv=r20141103&saldr=sa&correlator=2497140364047&frm=20&ga_vid=1110978199.1415841865&ga_sid=1416191613&ga_hid=1325587837&ga_fc=1&u_tz=-300&u_his=3&u_java=1&u_h=1440&u_w=2560&u_ah=1417&u_aw=2560&u_cd=24&u_nplug=14&u_nmime=83&dff=helvetica%20neue&dfs=14&adx=192&ady=354&biw=818&bih=656&eid=317150304&oid=3&rx=0&eae=0&fc=8&brdim=%2C%2C360%2C78%2C2560%2C23%2C818%2C735%2C818%2C656&vis=1&abl=CS&ppjl=u&fu=0&ifi=1&xpc=kMtoLxqabh&p=http%3A//www.plexify.com&dtd=110"""),
            http("request_6")
			.get(uri03 + """/pagead/imgad?id=CIKE8uqb5OntJRDUAxg8MgiOhKxp41ilsQ"""),
            http("request_7")
			.get(uri11 + """/ads?client=ca-pub-6132729926491277&output=html&h=60&slotname=1975783488&adk=512449286&w=468&lmt=1416191584&flash=15.0.0&url=http%3A%2F%2Fwww.plexify.com%2F&dt=1416191614681&bpp=2&bdt=65477&shv=r20141106&cbv=r20141103&saldr=sa&prev_slotnames=1975783488&correlator=2497140364047&frm=20&ga_vid=1110978199.1415841865&ga_sid=1416191613&ga_hid=1325587837&ga_fc=1&u_tz=-300&u_his=3&u_java=1&u_h=1440&u_w=2560&u_ah=1417&u_aw=2560&u_cd=24&u_nplug=14&u_nmime=83&dff=helvetica%20neue&dfs=14&adx=186&ady=511&biw=818&bih=656&eid=317150304&oid=3&rx=0&eae=0&fc=8&brdim=%2C%2C360%2C78%2C2560%2C23%2C818%2C735%2C818%2C656&vis=1&abl=CS&ppjl=u&fu=0&ifi=2&xpc=QFfMUIc2K6&p=http%3A//www.plexify.com&dtd=96"""),
            http("request_8")
			.get(uri11 + """/drt/s?v=r20120211"""),
            http("request_9")
			.get(uri11 + """/ads?client=ca-pub-6132729926491277&output=html&h=250&slotname=7128125487&adk=3179887034&w=250&lmt=1416191584&flash=15.0.0&url=http%3A%2F%2Fwww.plexify.com%2F&dt=1416191614694&bpp=2&bdt=65490&shv=r20141106&cbv=r20141103&saldr=sa&prev_slotnames=1975783488%2C1975783488&correlator=2497140364047&frm=20&ga_vid=1110978199.1415841865&ga_sid=1416191613&ga_hid=1325587837&ga_fc=1&u_tz=-300&u_his=3&u_java=1&u_h=1440&u_w=2560&u_ah=1417&u_aw=2560&u_cd=24&u_nplug=14&u_nmime=83&dff=helvetica%20neue&dfs=14&adx=606&ady=475&biw=818&bih=656&eid=317150304&oid=3&rx=0&eae=0&fc=8&brdim=%2C%2C360%2C78%2C2560%2C23%2C818%2C735%2C818%2C656&vis=1&abl=CS&ppjl=f&fu=0&ifi=3&xpc=hv1OxI8IoH&p=http%3A//www.plexify.com&dtd=147"""),
            http("request_10")
			.get(uri03 + """/simgad/386682512967472301""")
			.headers(headers_2),
            http("request_11")
			.get("http://" + uri13 + """/css?family=Roboto:300|Open+Sans:700|Open+Sans:300&lang=en""")
			.headers(headers_11),
            http("request_12")
			.get(uri03 + """/activeview?id=osdim&avi=BYaE0fl5pVLO_NtKRhASyk4L4BgCB2OaBHQAAEAE4AcgBBKAGBKgTgAE&ti=1&adk=737065353&p=354,192,414,660&tos=1126,0,0,0,0&mtos=1126,1126,1126,1126,1126&rs=1&ht=0&tfs=530&tls=1656&fp=client%3Dca-pub-6132729926491277%26url%3Dhttp%253A%252F%252Fwww.plexify.com%252F%26correlator%3D2497140364047%26eid%3D317150304%26oid%3D3&afp=%26output%3Dhtml%26slotname%3D1975783488%26flash%3D15.0.0%26dt%3D1416191614644%26adx%3D192%26ady%3D354%26ifi%3D1&tdl=225&abd=1-0-6&r=u&bs=818,656&bos=818,735&ps=856,2647&ss=2560,1440&tt=254&pt=1403&deb=1-3-3-4-7-4&tvt=1128&iframe_loc=http%3A%2F%2Fwww.plexify.com%2F&is=468,60&uc=6""")
			.headers(headers_2),
            http("request_13")
			.get(uri03 + """/activeview?id=osdim&avi=B_oSafl5pVOa8O8-qhATW4oGgDwCk8OriswEAABABOAHIAQOgBgOoE4AB&ti=1&adk=3179887034&p=475,606,725,856&tos=0,0,1119,0,0&mtos=0,0,1119,1119,1119&rs=1&ht=0&tfs=789&tls=1908&fp=client%3Dca-pub-6132729926491277%26url%3Dhttp%253A%252F%252Fwww.plexify.com%252F%26correlator%3D2497140364047%26eid%3D317150304%26oid%3D3&afp=%26output%3Dhtml%26slotname%3D7128125487%26flash%3D15.0.0%26dt%3D1416191614694%26adx%3D606%26ady%3D475%26ifi%3D3&abd=3-0-5&r=u&bs=818,656&bos=818,735&ps=856,2647&ss=2560,1440&tt=506&pt=1403&deb=1-3-3-5-8-4&tvt=1380&iframe_loc=http%3A%2F%2Fwww.plexify.com%2F&is=468,60&uc=5""")
			.headers(headers_2),
            http("request_14")
			.get(uri03 + """/activeview?id=osdim&avi=B6BZlfl5pVNGnOJWVhATgzoDwBwCo-9_2-AEAABABOAHIAQGoE4AB&ti=1&adk=512449286&p=511,186,571,654&tos=1114,0,0,0,0&mtos=1114,1114,1114,1114,1114&rs=1&ht=0&tfs=1298&tls=2412&fp=client%3Dca-pub-6132729926491277%26url%3Dhttp%253A%252F%252Fwww.plexify.com%252F%26correlator%3D2497140364047%26eid%3D317150304%26oid%3D3&afp=%26output%3Dhtml%26slotname%3D1975783488%26flash%3D15.0.0%26dt%3D1416191614681%26adx%3D186%26ady%3D511%26ifi%3D2&abd=5-0-5&r=u&bs=818,656&bos=818,735&ps=856,2647&ss=2560,1440&tt=1010&pt=1403&deb=1-3-3-6-10-4&tvt=1884&iframe_loc=http%3A%2F%2Fwww.plexify.com%2F&is=468,60&uc=5""")
			.headers(headers_2)))
		.pause(12)
		.exec(http("request_15")
			.get("http://" + uri10 + """/plex""")
			.resources(http("request_16")
			.get(uri06 + """/__utm.gif?utmwv=5.6.0&utms=2&utmn=1175131874&utmhn=www.plexify.com&utmcs=UTF-8&utmsr=2560x1440&utmvp=818x656&utmsc=24-bit&utmul=en-us&utmje=1&utmfl=15.0%20r0&utmdt=Plexify.%20Bringing%20together%20the%20web.&utmhid=1818145456&utmr=0&utmp=%2Fplex%2F&utmht=1416191630528&utmac=UA-2067442-6&utmcc=__utma%3D130107598.1110978199.1415841865.1415841865.1416191613.2%3B%2B__utmz%3D130107598.1415841865.1.1.utmcsr%3D(direct)%7Cutmccn%3D(direct)%7Cutmcmd%3D(none)%3B&utmjid=&utmu=qAAAAAAAAAAAAAAAAAAAAAAE~""")
			.headers(headers_2),
            http("request_17")
			.get(uri11 + """/ads?client=ca-pub-6132729926491277&output=html&h=250&slotname=7128125487&adk=3179887034&w=250&lmt=1416191630&flash=15.0.0&url=http%3A%2F%2Fwww.plexify.com%2Fplex%2F&dt=1416191631084&bpp=5&bdt=636&shv=r20141106&cbv=r20141103&saldr=sa&prev_slotnames=1975783488%2C1975783488&correlator=2451133768505&frm=20&ga_vid=1110978199.1415841865&ga_sid=1416191613&ga_hid=1818145456&ga_fc=1&u_tz=-300&u_his=4&u_java=1&u_h=1440&u_w=2560&u_ah=1417&u_aw=2560&u_cd=24&u_nplug=14&u_nmime=83&dff=helvetica%20neue&dfs=14&adx=606&ady=285&biw=818&bih=656&eid=317150304%2C828064101&oid=3&ref=http%3A%2F%2Fwww.plexify.com%2F&rx=0&eae=0&fc=8&brdim=%2C%2C360%2C78%2C2560%2C23%2C818%2C735%2C818%2C656&vis=1&abl=CS&ppjl=f&pfx=0&fu=0&ifi=3&xpc=wsq8VsHvzo&p=http%3A//www.plexify.com&dtd=87"""),
            http("request_18")
			.get(uri11 + """/ads?client=ca-pub-6132729926491277&output=html&h=60&slotname=1975783488&adk=737065353&w=468&lmt=1416191630&flash=15.0.0&url=http%3A%2F%2Fwww.plexify.com%2Fplex%2F&dt=1416191630906&bpp=3&bdt=459&shv=r20141106&cbv=r20141103&saldr=sa&correlator=2451133768505&frm=20&ga_vid=1110978199.1415841865&ga_sid=1416191613&ga_hid=1818145456&ga_fc=1&u_tz=-300&u_his=4&u_java=1&u_h=1440&u_w=2560&u_ah=1417&u_aw=2560&u_cd=24&u_nplug=14&u_nmime=83&dff=helvetica%20neue&dfs=14&adx=192&ady=722&biw=818&bih=656&eid=317150304&oid=3&ref=http%3A%2F%2Fwww.plexify.com%2F&rx=0&eae=0&fc=8&brdim=%2C%2C360%2C78%2C2560%2C23%2C818%2C735%2C818%2C656&vis=1&abl=CS&ppjl=f&fu=0&ifi=1&xpc=hFlel8mp1l&p=http%3A//www.plexify.com&dtd=98"""),
            http("request_19")
			.get(uri11 + """/ads?client=ca-pub-6132729926491277&output=html&h=60&slotname=1975783488&adk=512449286&w=468&lmt=1416191630&flash=15.0.0&url=http%3A%2F%2Fwww.plexify.com%2Fplex%2F&dt=1416191631007&bpp=2&bdt=559&shv=r20141106&cbv=r20141103&saldr=sa&prev_slotnames=1975783488&correlator=2451133768505&frm=20&ga_vid=1110978199.1415841865&ga_sid=1416191613&ga_hid=1818145456&ga_fc=1&u_tz=-300&u_his=4&u_java=1&u_h=1440&u_w=2560&u_ah=1417&u_aw=2560&u_cd=24&u_nplug=14&u_nmime=83&dff=helvetica%20neue&dfs=14&adx=186&ady=14223&biw=818&bih=656&eid=317150304&oid=3&ref=http%3A%2F%2Fwww.plexify.com%2F&rx=0&eae=0&fc=8&brdim=%2C%2C360%2C78%2C2560%2C23%2C818%2C735%2C818%2C656&vis=1&abl=CS&ppjl=f&fu=0&ifi=2&xpc=ZnwMwiF1Au&p=http%3A//www.plexify.com&dtd=64"""),
            http("request_20")
			.get(uri03 + """/pagead/imgad?id=CICAgKDjgeDKqgEQ-gEY-gEyCBpegyBfzPiD""")))
		.pause(1)
		.exec(http("request_21")
			.get(uri03 + """/activeview?id=osdim&avi=BZwcXj15pVJLGEcyphATcoYGIBwCRqtuAfwAAEAE4AcgBBKAGBKgTgAE&ti=1&adk=3179887034&p=285,606,535,856&tos=0,1125,0,0,0&mtos=0,1125,1125,1125,1125&rs=1&ht=0&tfs=474&tls=1599&fp=client%3Dca-pub-6132729926491277%26url%3Dhttp%253A%252F%252Fwww.plexify.com%252Fplex%252F%26correlator%3D2451133768505%26eid%3D317150304%26oid%3D3&afp=%26output%3Dhtml%26slotname%3D7128125487%26flash%3D15.0.0%26dt%3D1416191631084%26adx%3D606%26ady%3D285%26ifi%3D3&abd=3-0-5&r=u&bs=818,656&bos=818,735&ps=856,14368&ss=2560,1440&tt=1010&pt=590&deb=1-3-3-4-8-4&tvt=1278&iframe_loc=http%3A%2F%2Fwww.plexify.com%2Fplex%2F&is=468,60&uc=5""")
			.headers(headers_2))

	setUp(scn.inject(
		atOnceUsers(10),
		rampUsers(10) over(5 seconds)
		)).protocols(httpProtocol)
}
