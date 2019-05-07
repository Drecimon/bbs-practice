package cn.ljlin233.announce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ljlin233.announce.entity.Announce;
import cn.ljlin233.announce.entity.AnnounceResponse;
import cn.ljlin233.announce.service.AnnounceService;

/**
 * AnnounceController
 */
@Controller
@RequestMapping("/api")
public class AnnounceController {

    private AnnounceService announceService;

    public AnnounceController() {
        super();
    }

    @Autowired
    public AnnounceController(AnnounceService announceService) {
        this.announceService = announceService;
    }

    
    @RequestMapping(value = "/announces", method = RequestMethod.GET )
    @ResponseBody
    public AnnounceResponse getAllAnnounce() {
        List<Announce> announces = announceService.getAllAnnounces();
        int count = announceService.getAllAnnouncesCount();

        return new AnnounceResponse(count, announces);
    }


    @RequestMapping(value = "/announces",params = "page", method = RequestMethod.GET)
    @ResponseBody
    public AnnounceResponse getAnnouncesByPage(@RequestParam int page) {

        List<Announce> announces = announceService.getAnnouncesByPage(page, 10);
        int count = announceService.getAllAnnouncesCount();

        return new AnnounceResponse(count, announces);
    }


    @RequestMapping(value = "/announces", params = "id", method = RequestMethod.GET)
    @ResponseBody
    public Announce getAnnounceById(@RequestParam int id) {
        Announce announce = announceService.getAnnounceById(id);
        return announce;
    }

    @RequestMapping(value = "/announces", params = {"search", "page"}, method = RequestMethod.GET)
    @ResponseBody
    public AnnounceResponse searchAnnounces(@RequestParam String search, @RequestParam int page ) {
        List<Announce> announces = announceService.searchAnnounces(search, page, 10);
        int count = announceService.getSearchCount(search);

        return new AnnounceResponse(count, announces);

    }

    @RequestMapping(value = "/announces", params = {"departmentId", "page"}, method = RequestMethod.GET)
    @ResponseBody
    public AnnounceResponse getAnnounceByDepartment(@RequestParam int departmentId, @RequestParam int page) {
        List<Announce> announces = announceService.getAnnouncesByDepartment(departmentId, page, 10);
        int count = announceService.getDepartmentAnnounceCount(departmentId);

        return new AnnounceResponse(count, announces);
    }


    @RequestMapping(value = "/announces", method = RequestMethod.POST)
    public void addAnnounce(HttpServletRequest request) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int upUserId = Integer.valueOf(request.getParameter("upUserId"));
        String savePath = request.getParameter("savePath");

        announceService.addAnnounce(title, content, upUserId, savePath);

    }


    @RequestMapping(value = "/announces", params = "id" , method = RequestMethod.PUT)
    public void updateAnnounce(@RequestParam int id, HttpServletRequest request) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String savePath = request.getParameter("savePath");

        announceService.updateAnnounce(id, title, content, savePath);
    }


    @RequestMapping(value = "/announces", params = "id" , method = RequestMethod.DELETE)
    public void deleteAnnounce(@RequestParam int id) {
        announceService.deleteAnnounce(id);
    }

}