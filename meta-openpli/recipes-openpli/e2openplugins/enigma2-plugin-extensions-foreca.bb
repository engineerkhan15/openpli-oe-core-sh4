MODULE = "Foreca"
DESCRIPTION = "Weather forecast for the upcoming 10 days"
RDEPENDS_${PN} = "python-html"

inherit gitpkgv
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

require conf/license/license-gplv2.inc
require openplugins-distutils.inc

FILES_${PN} += "/etc/enigma2/Foreca"
CONFFILES_${PN} = "/etc/enigma2/Foreca/City.cfg /etc/enigma2/Foreca/Filter.cfg"
