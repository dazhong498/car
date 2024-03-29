package by.pvt.util;

import org.springframework.stereotype.Component;

import by.pvt.dto.CarSortingDTO;
import by.pvt.dto.OrderSortingDTO;

import javax.servlet.http.HttpServletRequest;

import static by.pvt.constants.Constants.*;

/**
 * Class for getting sorting params from the user interface
 */
@Component("sorting")
public class Sorting {

    public Sorting() {
    }

    /**
     * the method gets the sort order
     *
     * @param request
     * @return
     */
    public boolean getSorting(HttpServletRequest request) {
        boolean flag = true;
        if (request.getParameter(SORT_TYPE) != null) {
            flag = Boolean.parseBoolean(request.getParameter(SORT_TYPE));
        }
        request.setAttribute(SORT_TYPE, flag);
        return flag;
    }

    /**
     * the method gets the parameters for sorting
     *
     * @param request
     * @return
     */
    public CarSortingDTO getSortingParam(HttpServletRequest request) {
        CarSortingDTO sortingDTO = new CarSortingDTO();
        setCarSortingDTO(sortingDTO);
        if (request.getParameter(SORT_NAME) != null) {
            String param = request.getParameter(SORT_NAME);
            if (param.equals(AUTO_BRAND)) {
                sortingDTO.setBrand(param);
            }
            if (param.equals(AUTO_BODY_TYPE)) {
                sortingDTO.setBodyType(param);
            }
            if (param.equals(AUTO_ENGINE_TYPE)) {
                sortingDTO.setEngineType(param);
            }
            if (param.equals(AUTO_TRANSMISSION_TYPE)) {
                sortingDTO.setTransmissionType(param);
            }
            if (param.equals(AUTO_AMOUNT_PER_DAY)) {
                sortingDTO.setAmount(param);
            }
            if (param.equals(YEAR_OF_MANUFACTURE)) {
                sortingDTO.setYear(param);
            }
            request.setAttribute(SORT_NAME, param);
        } else {
            sortingDTO.setBrand(AUTO_BRAND);
            request.setAttribute(SORT_NAME, AUTO_BRAND);
        }
        return sortingDTO;
    }

    /**
     * sets default params
     *
     * @param sortingDTO
     */
    private void setCarSortingDTO(CarSortingDTO sortingDTO) {
        sortingDTO.setBrand("");
        sortingDTO.setBodyType("");
        sortingDTO.setEngineType("");
        sortingDTO.setTransmissionType("");
        sortingDTO.setAmount("");
        sortingDTO.setYear("");
    }

    /**
     * the method gets the parameters for sorting
     *
     * @param request
     * @return
     */
    public OrderSortingDTO getSortingParamOrder(HttpServletRequest request) {
        OrderSortingDTO sortingDTO = new OrderSortingDTO();
        sortingDTO.setStartDate("");
        sortingDTO.setEndDate("");
        sortingDTO.setAmount("");
        sortingDTO.setStatus("");

        if (request.getParameter(SORT_NAME) != null) {
            String param = request.getParameter(SORT_NAME);
            if (param.equals(ISSUE_DATE)) {
                sortingDTO.setStartDate(param);
            } else {
                sortingDTO.setStartDate("");
            }
            if (param.equals(END_DATE)) {
                sortingDTO.setEndDate(param);
            } else {
                sortingDTO.setEndDate("");
            }
            if (param.equals(AUTO_AMOUNT_PER_DAY)) {
                sortingDTO.setAmount(param);
            } else {
                sortingDTO.setAmount("");
            }
            if (param.equals(STATUS)) {
                sortingDTO.setStatus(param);
            } else {
                sortingDTO.setStatus("");
            }
            request.setAttribute(SORT_NAME, param);
        } else {
            sortingDTO.setBrand(ID);
            request.setAttribute(SORT_NAME, ID);
        }
        return sortingDTO;
    }
}
