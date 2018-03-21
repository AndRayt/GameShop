package com.labratorij.gameshop.controller;

import com.labratorij.gameshop.entity.*;
import com.labratorij.gameshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PlatformService platformService;
    @Autowired
    private VideogameService videogameService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "index";
    }

    /**
     * Методы для просмотра таблиц
     */
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String clients(ModelMap model) {
        model.addAttribute("clients", clientService.getAll());
        return "clients";
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String employees(ModelMap model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employees";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(ModelMap model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @RequestMapping(value = "/platforms", method = RequestMethod.GET)
    public String platforms(ModelMap model) {
        model.addAttribute("platforms", platformService.getAll());
        return "platforms";
    }

    @RequestMapping(value = "/videogames", method = RequestMethod.GET)
    public String videogames(ModelMap model) {
        model.addAttribute("videogames", videogameService.getAll());
        return "videogames";
    }

    /**
     * Методы для добавления записей
     */
    @RequestMapping(value = "/clients/add", method = RequestMethod.GET)
    public String getAddClient(ModelMap model) {
        model.addAttribute("clientAttribute", new ClientEntity());
        return "clientAddPage"; //переходим к jsp с добавлением клиента
    }

    @RequestMapping(value = "/clients/add", method = RequestMethod.POST)
    public String postAddClient(@ModelAttribute("clientAttribute") ClientEntity client) {
        clientService.add(client);
        return "redirect:/clients"; //переходим к методу clients
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.GET)
    public String getAddEmployee(ModelMap model) {
        model.addAttribute("employeeAttribute", new EmployeeEntity());
        return "employeeAddPage";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
    public String postAddEmployee(@ModelAttribute("employeeAttribute") EmployeeEntity employee) {
        employeeService.add(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.GET)
    public String getAddOrder(ModelMap model) {
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        return "orderAddPage";
    }

    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public String postAddOrder(@RequestParam("date") Date date, @RequestParam("clId") Integer clId, @RequestParam("empId") Integer empId) {
        OrderEntity order = new OrderEntity();
        order.setDate(date);
        order.setClient(clientService.get(clId));
        order.setEmployee(employeeService.get(empId));
        orderService.add(order);
        return "redirect:/orders";
    }

    @RequestMapping(value = "/platforms/add", method = RequestMethod.GET)
    public String getAddPlatform(ModelMap model) {
        model.addAttribute("platformAttribute", new PlatformEntity());
        return "platformAddPage";
    }

    @RequestMapping(value = "/platforms/add", method = RequestMethod.POST)
    public String postAddPlatform(@ModelAttribute("platformAttribute") PlatformEntity platform) {
        platformService.add(platform);
        return "redirect:/platforms";
    }

    @RequestMapping(value = "/videogames/add", method = RequestMethod.GET)
    public String getAddVideogame(ModelMap model) {
        //VideogameEntity videogameEntity = new VideogameEntity();
        //videogameEntity.setPlatfrom(new ArrayList<PlatformEntity>());
        model.addAttribute("videogameAttribute", new VideogameEntity());
        return "videogameAddPage";
    }

    @RequestMapping(value = "/videogames/add", method = RequestMethod.POST)
    public String postAddVideogame(@ModelAttribute("employeeAttribute") VideogameEntity videogame) {
        videogameService.add(videogame);
        return "redirect:/videogames";
    }

    /**
     * Методы для удаления записей
     */
    @RequestMapping(value = "/clients/delete", method = RequestMethod.GET)
    public String deleteClient(@RequestParam(value="id") Integer id, ModelMap model) {
        clientService.delete(id);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/employees/delete", method = RequestMethod.GET)
    public String deleteEmployee(@RequestParam(value="id") Integer id, ModelMap model) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/orders/delete", method = RequestMethod.GET)
    public String deleteOrder(@RequestParam(value="id") Integer id, ModelMap model) {
        orderService.delete(id);
        return "redirect:/orders";
    }

    @RequestMapping(value = "/platforms/delete", method = RequestMethod.GET)
    public String deletePlatform(@RequestParam(value="id") Integer id, ModelMap model) {
        platformService.delete(id);
        return "redirect:/platforms";
    }

    @RequestMapping(value = "/videogames/delete", method = RequestMethod.GET)
    public String deleteVideogame(@RequestParam(value="id") Integer id, ModelMap model) {
        videogameService.delete(id);
        return "redirect:/videogames";
    }
    /**
     * Методы для изменения записей
     */
    @RequestMapping(value = "/clients/edit", method = RequestMethod.GET)
    public String getEditClient(@RequestParam(value="id") Integer id, ModelMap model) {
        model.addAttribute("clientAttribute", clientService.get(id));
        return "clientEditPage";
    }

    @RequestMapping(value = "/clients/edit", method = RequestMethod.POST)
    public String postEditClient(@ModelAttribute("clientAttribute") ClientEntity client, @RequestParam(value="id") Integer id, ModelMap model) {
        clientService.edit(client, id);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/employees/edit", method = RequestMethod.GET)
    public String getEditEmployee(@RequestParam(value="id") Integer id, ModelMap model) {
        model.addAttribute("employeeAttribute", employeeService.get(id));
        return "employeeEditPage";
    }

    @RequestMapping(value = "/employees/edit", method = RequestMethod.POST)
    public String postEditEmpmployee(@ModelAttribute("employeeAttribute") EmployeeEntity employee, @RequestParam(value="id") Integer id, ModelMap model) {
        employeeService.edit(employee, id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/orders/edit", method = RequestMethod.GET)
    public String getEditOrder(@RequestParam(value="id") int id, ModelMap model) {
        model.addAttribute("orderId", id);
        return "orderEditPage";
    }

    @RequestMapping(value = "/orders/edit", method = RequestMethod.POST)
    public String postEditOrder(@ModelAttribute("orderId") int id, @RequestParam(value="date") Date date, ModelMap model) {
        orderService.changeDate(id, date);
        return "redirect:/orders";
    }

    /*@RequestMapping(value = "/orders/edit", method = RequestMethod.GET)
    public String getEditOrder(ModelMap model, @RequestParam(value="id") Integer id) {
        model.addAttribute("clients", clientService.getAll());
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("orderAttribute", orderService.get(id));
        return "orderEditPage";
    }

    @RequestMapping(value = "/orders/edit", method = RequestMethod.POST)
    public String postEditOrder(@ModelAttribute("orderAttribute") OrderEntity order, @RequestParam("date") Date date, @RequestParam("clId") Integer clId, @RequestParam("empId") Integer empId) {
        order.setDate(date);
        order.setEmployee(employeeService.get(empId));
        order.setClient(clientService.get(clId));
        orderService.save(order);
        return "redirect:/orders";
    }*/

    @RequestMapping(value = "/platforms/edit", method = RequestMethod.GET)
    public String getEditPlatform(@RequestParam(value="id") Integer id, ModelMap model) {
        model.addAttribute("platformAttribute", platformService.get(id));
        return "platformEditPage";
    }

    @RequestMapping(value = "/platforms/edit", method = RequestMethod.POST)
    public String postEditPlatform(@ModelAttribute("platformAttribute") PlatformEntity platform, @RequestParam(value="id") Integer id, ModelMap model) {
        platformService.edit(platform, id);
        return "redirect:/platforms";
    }

    @RequestMapping(value = "/videogames/edit", method = RequestMethod.GET)
    public String getEditVideogame(@RequestParam(value="id") Integer id, ModelMap model) {
        model.addAttribute("videogameAttribute", videogameService.get(id));
        return "videogameEditPage";
    }

    @RequestMapping(value = "/videogames/edit", method = RequestMethod.POST)
    public String postEditVideogame(@ModelAttribute("videogameAttribute") VideogameEntity videogame, @RequestParam(value="id") Integer id, ModelMap model) {
        videogameService.edit(videogame, id);
        return "redirect:/videogames";
    }

    /**
     * Дополнительные REST запросы
     */
    //получить лист заказов для данного клиента
    @RequestMapping(value = "/get_list_orders", method = RequestMethod.GET)
    public String orders(ModelMap model, @RequestParam(value="id") Integer id) {
        model.addAttribute("orders", clientService.get(id).getOrdersByClientId());
        return "orders";
    }

    //сделать связь videogames-platforms
    @RequestMapping(value = "/set_vg_pl", method = RequestMethod.GET)
    public String vdPlGet(ModelMap model) {
        model.addAttribute("videogames", videogameService.getAll());
        model.addAttribute("platforms", platformService.getAll());
        return "vgPl";
    }

    @RequestMapping(value = "/set_vg_pl", method = RequestMethod.POST)
    public String vdPlPost(@RequestParam(value="plId") Integer plId, @RequestParam(value="vgId") Integer vgId) {
        platformService.addVideogameList(vgId, plId);
        return "redirect:/platforms";
    }

    //сделать связь videogames-orders
    @RequestMapping(value = "/set_vg_or", method = RequestMethod.GET)
    public String vdOrGet(ModelMap model) {
        model.addAttribute("videogames", videogameService.getAll());
        model.addAttribute("orders", orderService.getAll());
        return "vgOr";
    }

    @RequestMapping(value = "/set_vg_or", method = RequestMethod.POST)
    public String vdOrPost(@RequestParam(value="orId") Integer orId, @RequestParam(value="vgId") Integer vgId) {
        orderService.addVideogameList(vgId, orId);
        return "redirect:/orders";
    }

    //просмотр видеоигр в заказе
    @RequestMapping(value = "/orders/videogames", method = RequestMethod.GET)
    public String ordersVideogames(@RequestParam(value="id") Integer id, ModelMap model) {
        model.addAttribute("videogames", orderService.get(id).getVideogames());
        return "videogames";
    }

    //просмотр видеоигр для данной платформы
    @RequestMapping(value = "/platforms/videogames", method = RequestMethod.GET)
    public String platformsVideogames(@RequestParam(value="id") Integer id, ModelMap model) {
        model.addAttribute("videogames", platformService.get(id).getVideogames());
        return "videogames";
    }
}
