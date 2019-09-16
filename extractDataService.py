# -*- coding: utf-8 -*-

import os
import json
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

newfile=open('extractData.json','r')
extractData=json.load(newfile)
extractData = json.dumps(extractData)
newfile.close()
