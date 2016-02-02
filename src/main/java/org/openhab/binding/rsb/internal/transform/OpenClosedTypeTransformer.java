package org.openhab.binding.rsb.internal.transform;

/*
 * #%L
 * openHAB RSB Binding
 * %%
 * Copyright (C) 2014 - 2016 DivineCooperation
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import org.dc.jul.exception.CouldNotTransformException;
import org.dc.jul.exception.TypeNotSupportedException;
import org.openhab.core.library.types.OpenClosedType;
import rst.homeautomation.openhab.OpenClosedHolderType;

/**
 *
 * @author thuxohl
 */
public class OpenClosedTypeTransformer {

    public static rst.homeautomation.openhab.OpenClosedHolderType.OpenClosedHolder transform(OpenClosedType openClosedType) throws CouldNotTransformException {
        switch (openClosedType) {
            case OPEN:
                return rst.homeautomation.openhab.OpenClosedHolderType.OpenClosedHolder.newBuilder().setState(OpenClosedHolderType.OpenClosedHolder.OpenClosed.OPEN).build();
            case CLOSED:
                return rst.homeautomation.openhab.OpenClosedHolderType.OpenClosedHolder.newBuilder().setState(OpenClosedHolderType.OpenClosedHolder.OpenClosed.CLOSED).build();
            default:
                throw new CouldNotTransformException("Could not transform " + OpenClosedType.class.getName() + "! " + OpenClosedType.class.getSimpleName() + "[" + openClosedType.name() + "] is unknown!");
        }
    }

    public static OpenClosedType transform(rst.homeautomation.openhab.OpenClosedHolderType.OpenClosedHolder.OpenClosed openClosed) throws TypeNotSupportedException, CouldNotTransformException {
        switch (openClosed) {
            case OPEN:
                return OpenClosedType.OPEN;
            case CLOSED:
                return OpenClosedType.CLOSED;
            default:
                throw new CouldNotTransformException("Could not transform " + rst.homeautomation.openhab.OpenClosedHolderType.OpenClosedHolder.OpenClosed.class.getName() + "! " + rst.homeautomation.openhab.OpenClosedHolderType.OpenClosedHolder.OpenClosed.class.getSimpleName() + "[" + openClosed.name() + "] is unknown!");
        }
    }
}
