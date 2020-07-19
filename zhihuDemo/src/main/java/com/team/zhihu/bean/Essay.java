
package com.team.zhihu.bean;

public class Essay {
    private Integer id;

    public Essay(Integer id, String title, String context, Integer goodnum, Integer type, Integer topictype,
			Integer userid, String date) {
		super();
		this.id = id;
		this.title = title;
		this.context = context;
		this.goodnum = goodnum;
		this.type = type;
		this.topictype = topictype;
		this.userid = userid;
		this.date = date;
	}

	public Essay() {
		// TODO 自动生成的构造函数存根
		super();
	}

	private String title;

    private String context;

    private Integer goodnum;

    private Integer type;//0是文章，1是提问

    private Integer topictype;

    private Integer userid;

    private String date;
    private User user;
    private Topic topic;

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public Integer getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(Integer goodnum) {
        this.goodnum = goodnum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTopictype() {
        return topictype;
    }

    public void setTopictype(Integer topictype) {
        this.topictype = topictype;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }
}